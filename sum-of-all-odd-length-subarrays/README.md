<h2>1588. Sum of All Odd Length Subarrays</h2><h3>Easy</h3><hr><div><p>Given an array of positive integers&nbsp;<code>arr</code>, calculate the sum of all possible odd-length subarrays.</p>

<p>A subarray is a contiguous&nbsp;subsequence of the array.</p>

<p>Return&nbsp;<em>the sum of all odd-length subarrays of&nbsp;</em><code>arr</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [1,4,2,5,3]
<strong>Output:</strong> 58
<strong>Explanation: </strong>The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1,2]
<strong>Output:</strong> 3
<b>Explanation: </b>There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [10,11,12]
<strong>Output:</strong> 66
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 100</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>
</div>

My Learning: 

 The basic idea behind the approach is to compute the sum, but not in the order intended. For
example, take a look at the array [1, 2, 3, 4]. The subarrays are
   									[1]  [2]  [3]  [4]
   								[1, 2]   [2, 3]   [3, 4]
   								  [1, 2, 3]   [2, 3, 4]
   									   [1, 2, 3, 4]
Notice how many copies of each element there are. There are four 1's, six 2's, six 3's, and
four 4's. If we could efficiently compute how many copies of each element there are across
all the different subarrays, we could directly compute the sum by multiply each element
in the array by the number of times it appears across all the subarrays and then adding
them up.
You can find a bunch of interesting patterns with how many times each number shows
up. Here's one useful one. We can count the number of subarrays that overlap a particular element at index i by counting those subarrays and focusing on the index at which
those subarrays start. The first element of the array will appear in n different subarrays
– each of them starts at the first position. The second element of the array will appear in
n­1 subarrays that begin at its position, plus  n­1 subarrays from the previous position
(there are n total intervals, of which one has length one and therefore won't reach the second element). The third element of the array will appear in n­2 subarrays that begin in
its position, plus n­2 subarrays beginning at the first element (all n arrays, minus the one
of length two and the one of length one) and n­2 subarrays beginning at the second element (all n­1 of them except for the one of length one). More generally, the ith element
will open n – i new intervals (one for each length stretching out to the end) and, for each
preceding element, will overlap n – i of the intervals starting there. This means that the
total number of intervals overlapping element i is given by
(n – i)i + (n – i) = (n – i)(i + 1)
 
