<h2>21. Merge Two Sorted Lists</h2><h3>Easy</h3><hr><div><p>Merge two sorted linked lists and return it as a <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;">
<pre><strong>Input:</strong> l1 = [1,2,4], l2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> l1 = [], l2 = []
<strong>Output:</strong> []
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> l1 = [], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>l1</code> and <code>l2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>
</div>

Learning:

                                 *LOGIC*                                 
 We use a recurisve approach here, it requires us to make two decisions.  

                  1.  When will we stop our recursion?

  If l1 is null? Well we just want to return the rest of l2.
  If l2 is null? Well we just want to return the rest of l1.

                  2.  When will we call our function again?

  Assume 'l1' is smaller between 'l1' and 'l2'
  We want to set our 'res' to 'l1' and now we want to 
  find which is smaller between 'l1.next' and 'l2'
  So we call :   
                  res = l1;
                  res.next = mergeTwoLists(l1.next,l2);
  If 'l1' is smaller.

  Similarly if 'l2' is smaller 
 We want to call : 
                  res = l2;
                  res.next = mergeTwoLists(l1,l2.next);
  If 'l2' is smaller.


  Eventually, l1 or l2 will be null, our base case will be true
 we will return back out of our recursion building res in the process.
