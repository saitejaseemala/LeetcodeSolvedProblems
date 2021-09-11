<h2>1266. Minimum Time Visiting All Points</h2><h3>Easy</h3><hr><div><p>On a 2D plane, there are <code>n</code> points with integer coordinates <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>. Return <em>the <strong>minimum time</strong> in seconds to visit all the points in the order given by </em><code>points</code>.</p>

<p>You can move according to these rules:</p>

<ul>
	<li>In <code>1</code> second, you can either:

	<ul>
		<li>move vertically by one&nbsp;unit,</li>
		<li>move horizontally by one unit, or</li>
		<li>move diagonally <code>sqrt(2)</code> units (in other words, move one unit vertically then one unit horizontally in <code>1</code> second).</li>
	</ul>
	</li>
	<li>You have to visit the points in the same order as they appear in the array.</li>
	<li>You are allowed to pass through points that appear later in the order, but these do not count as visits.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/1626_example_1.PNG" style="width: 500px; height: 428px;">
<pre><strong>Input:</strong> points = [[1,1],[3,4],[-1,0]]
<strong>Output:</strong> 7
<strong>Explanation: </strong>One optimal path is <strong>[1,1]</strong> -&gt; [2,2] -&gt; [3,3] -&gt; <strong>[3,4] </strong>-&gt; [2,3] -&gt; [1,2] -&gt; [0,1] -&gt; <strong>[-1,0]</strong>   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> points = [[3,2],[-2,2]]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>points.length == n</code></li>
	<li><code>1 &lt;= n&nbsp;&lt;= 100</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-1000&nbsp;&lt;= points[i][0], points[i][1]&nbsp;&lt;= 1000</code></li>
</ul>
</div>

Learning:

Key thing to take away from the given constraints: we're calculating time (seconds) and moving diagonally takes 1 second (though it takes sqrt(2) distance units)
To find minimum distance between two points (x1, y1) and (x2, y2):

First find the difference between x-coordinates: dx = Math.abs(x1 - x2)
Then find the difference between y-coordinates: dy = Math.abs(y1 - y2)
Now the tricky part about diagonal traversal:
Think of it this way: The more distance units you cover in 1 second, the less time it will take to reach the destination point.
So for diagonal traversal, the distance covered is sqrt(2) units which is preferrable (and of course more than) compared to traversing horizontally or vertically (which are 1 unit respectively).
So we prefer traversing diagonally from (x1, y1) until we reach on the same horizontal or vertical level of (x2, y2) (either x2 or y2)
This can be achieved by finding the minimum diagonal steps/time/units required: diagonalSteps = Math.min(dx, dy)
Once diagonal traversal is done, the only remaining steps would be either the difference in X-axis or Y-axis.
So:
remaining_x_steps = dx - diagonalSteps and,
remaining_y_steps = dy - diagonalSteps (do note that one of them will surely be 0)
So the total number of steps would be: minSteps = diagonalSteps + remaining_x_steps + remaining_y_steps
Now you can rewrite the above expression and make it shorter (do follow):
=> minSteps = Math.min(dx, dy) + dx - Math.min(dx, dy) + dy - Math.min(dx, dy)
=> minSteps = dx + dy - Math.min(dx, dy)
=>minSteps = Math.max(dx, dy)
(How? If you check the previous equation, it is trying to eliminate the minimum value leaving the maximum one.
E.g: 2 + 3 - min(2, 3) = 3 = max(2, 3))

Example:
(x1, y1) = (3, 5)
(x2, y2) = (7, 10)

dx = Math.abs(x1-x2) = 4
dy = Math.abs(y1-y2) = 5
Now, you would consider traversing diagonally as much as possible (because covering more distance units per second is more desirable and diagonal distance length is sqrt(2) which is greater than 1 unit if traversed horizontally or vertically)

So, (3, 5) => (4, 6) => (5, 7) => (6, 8) => (7, 9) (you traversed until it matches the x-coordinate of the destination point - whichever comes first)

Hence,diagonalSteps = Math.min(dx, dy) = 4 (which if see the above statement - took 4 seconds to reach)

In order to reach (7,10) from (7, 9) => all you have to do is traverse vertically by 1 unit

So, remaining_x_steps = 0 (dx - diagonalSteps) but remaining_y_steps = 1 (dy - diagonalSteps)
