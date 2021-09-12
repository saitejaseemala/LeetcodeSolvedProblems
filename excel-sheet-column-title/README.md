<h2>168. Excel Sheet Column Title</h2><h3>Easy</h3><hr><div><p>Given an integer <code>columnNumber</code>, return <em>its corresponding column title as it appears in an Excel sheet</em>.</p>

<p>For example:</p>

<pre>A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> columnNumber = 1
<strong>Output:</strong> "A"
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> columnNumber = 28
<strong>Output:</strong> "AB"
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> columnNumber = 701
<strong>Output:</strong> "ZY"
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> columnNumber = 2147483647
<strong>Output:</strong> "FXSHRXW"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnNumber &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>



Learning:

The solution is simple, the only question could be why reduce column number by 1?
Explanation: columnNumer ranges from [1, 26] corresponding to [A, Z]. On doing columnNumer mod 26, we get values [1,... 25, 0] for [A, Z], which is undesirable, since we want values's min to be for A and max to be for Z. To achieve this, we need to SHIFT the entire range to the left by 1, so that we get [0, 25] for [A, Z]. Now the min(range) = 0 is for A and max(range) = 25 is for Z. This shifting is not only required for append call but also for update step columnNumber /= 26 because its output is the input of the next iteration so again columnNumer mod 26 needs to be [0, 25]. You can visualize better by thinking recursively here.

public String convertToTitle(int columnNumber) {
	return getTitle(columnNumber, new StringBuilder());
}

private String getTitle(int n, StringBuilder title) {
	return (n == 0) ? title.reverse().toString() : getTitle(--n / 26, title.appendCodePoint('A' + n % 26));
}
Note:

Don't use string concatenation (+ operator) in a loop. Its an O(n) operation.
Don't use StringBuilder's insert(0, ...) i.e. add at beginning operation. Its an O(n) operation.
Recursive method will have space complexity same as time complexity because it'd use function call stack.
