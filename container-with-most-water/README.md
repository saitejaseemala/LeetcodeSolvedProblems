<h2>11. Container With Most Water</h2><h3>Medium</h3><hr><div><p>Given <code>n</code> non-negative integers <code>a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub></code><sub> </sub>, where each represents a point at coordinate <code>(i, a<sub>i</sub>)</code>. <code>n</code> vertical lines are drawn such that the two endpoints of the line <code>i</code> is at <code>(i, a<sub>i</sub>)</code> and <code>(i, 0)</code>. Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;">
<pre><strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain&nbsp;is 49.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> height = [4,3,2,1,4]
<strong>Output:</strong> 16
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> height = [1,2,1]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div>

Learnings:

The first thing we should realize is that the amount of water contained is always going to be a rectangle whose area is defined as length * width. The width of any container will be the difference between the index of the two lines (i and j), and the height will be whichever of the two sides is the lowest (min(H[i], H[j])).

The brute force approach would be to compare every single pair of indexes in H, but that would be far too slow. Instead, we can observe that if we start with the lines on the opposite ends and move inward, the only possible time the area could be larger is when the height increases, since the width will continuously get smaller.

This is very easily observed with the use of visuals. Let's say we start with a graph of H like this:

Visual 1

The first step would be to find our starting container described by the lines on either end:

Visual 2

We can tell that the line on the right end will never make a better match, because any further match would have a smaller width and the container is already the maximum height that that line can support. That means that our next move should be to slide j to the left and pick a new line:

Visual 3

This is a clear improvement over the last container. We only moved over one line, but we more than doubled the height. Now, it's the line on the left end that's the limiting factor, so the next step will be to slide i to the right. Just looking at the visual, however, it's obvious that we can skip the next few lines because they're already underwater, so we should go to the first line that's larger than the current water height:

Visual 4

This time, it doesn't look like we made much of a gain, despite the fact that the water level rose a bit, because we lost more in width than we made up for in height. That means that we always have to check at each new possible stop to see if the new container area is better than the current best. Just lik before we can slide j to the left again:

Visual 5

This move also doesn't appear to have led to a better container. But here we can see that it's definitely possible to have to move the same side twice in a row, as the j line is still the lower of the two:

Visual 6

This is obviously the last possible container to check, and like the last few before it, it doesn't appear to be the best match. Still, we can understand that it's entirely possible for the best container in a different example to be only one index apart, if both lines are extremely tall.

Putting together everything, it's clear that we need to make a 2-pointer sliding window solution. We'll start from either end and at each step we'll check the container area, then we'll shift the lower-valued pointer inward. Once the two pointers meet, we know that we must have exhausted all possible containers and we should return our answer (ans).

