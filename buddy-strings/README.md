<h2>859. Buddy Strings</h2><h3>Easy</h3><hr><div><p>Given two strings <code>s</code> and <code>goal</code>, return <code>true</code><em> if you can swap two letters in </em><code>s</code><em> so the result is equal to </em><code>goal</code><em>, otherwise, return </em><code>false</code><em>.</em></p>

<p>Swapping letters is defined as taking two indices <code>i</code> and <code>j</code> (0-indexed) such that <code>i != j</code> and swapping the characters at <code>s[i]</code> and <code>s[j]</code>.</p>

<ul>
	<li>For example, swapping at indices <code>0</code> and <code>2</code> in <code>"abcd"</code> results in <code>"cbad"</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ab", goal = "ba"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> s = "ab", goal = "ab"
<strong>Output:</strong> false
<strong>Explanation:</strong> The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> s = "aa", goal = "aa"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> s = "aaaaaaabc", goal = "aaaaaaacb"
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, goal.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>goal</code> consist of lowercase letters.</li>
</ul>
</div>

Learning:

Using 2 indices diff1, diff2 to store up to 2 different places between string A and string B.
If there are more than 2 different places -> Invalid.
If there are 2 different places -> Compare A[diff1] vs B[diff2] and A[diff2] vs B[diff1].
If there is only 1 different places -> Invalid.
If no difference between A and B then check if A contains at least 1 duplicate letters so that we can swap them.
Example 1: A = "ab", B = "ab"
Example 2: A = "aab", B = "aab",
