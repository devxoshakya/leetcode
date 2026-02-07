#!/usr/bin/env python3
"""
Generate GitHub Pages HTML for LeetCode solutions.
"""
import os
import re
import json
from pathlib import Path
from datetime import datetime

# All LeetCode Easy problems to track
EASY_PROBLEMS = [
    (1, "Two Sum"), (21, "Merge Two Sorted Lists"), (35, "Search Insert Position"),
    (58, "Length of Last Word"), (70, "Climbing Stairs"), (83, "Remove Duplicates from Sorted List"),
    (88, "Merge Sorted Array"), (100, "Same Tree"), (101, "Symmetric Tree"),
    (104, "Maximum Depth of Binary Tree"), (110, "Balanced Binary Tree"), (112, "Path Sum"),
    (118, "Pascal's Triangle"), (121, "Best Time to Buy and Sell Stock"), (125, "Valid Palindrome"),
    (136, "Single Number"), (141, "Linked List Cycle"), (160, "Intersection of Two Linked Lists"),
    (169, "Majority Element"), (171, "Excel Sheet Column Number"), (191, "Number of 1 Bits"),
    (202, "Happy Number"), (203, "Remove Linked List Elements"), (205, "Isomorphic Strings"),
    (206, "Reverse Linked List"), (217, "Contains Duplicate"), (219, "Contains Duplicate II"),
    (226, "Invert Binary Tree"), (231, "Power of Two"), (235, "Lowest Common Ancestor of a BST"),
    (237, "Delete Node in a Linked List"), (242, "Valid Anagram"), (257, "Binary Tree Paths"),
    (258, "Add Digits"), (268, "Missing Number"), (278, "First Bad Version"),
    (283, "Move Zeroes"), (290, "Word Pattern"), (292, "Nim Game"),
    (326, "Power of Three"), (342, "Power of Four"), (344, "Reverse String"),
    (345, "Reverse Vowels of a String"), (349, "Intersection of Two Arrays"),
    (350, "Intersection of Two Arrays II"), (367, "Valid Perfect Square"),
    (371, "Sum of Two Integers"), (374, "Guess Number Higher or Lower"),
    (383, "Ransom Note"), (387, "First Unique Character in a String"),
    (389, "Find the Difference"), (392, "Is Subsequence"), (404, "Sum of Left Leaves"),
    (405, "Convert a Number to Hexadecimal"), (409, "Longest Palindrome"),
    (412, "Fizz Buzz"), (415, "Add Strings"), (434, "Number of Segments in a String"),
    (441, "Arranging Coins"), (448, "Find All Numbers Disappeared in an Array"),
    (461, "Hamming Distance"), (463, "Island Perimeter"), (485, "Max Consecutive Ones"),
    (492, "Construct the Rectangle"), (496, "Next Greater Element I"), (500, "Keyboard Row"),
    (509, "Fibonacci Number"), (520, "Detect Capital"), (541, "Reverse String II"),
    (543, "Diameter of Binary Tree"), (551, "Student Attendance Record I"),
    (557, "Reverse Words in a String III"), (561, "Array Partition"),
    (566, "Reshape the Matrix"), (572, "Subtree of Another Tree"),
    (575, "Distribute Candies"), (589, "N-ary Tree Preorder Traversal"),
    (605, "Can Place Flowers"), (617, "Merge Two Binary Trees"),
    (637, "Average of Levels in Binary Tree"), (645, "Set Mismatch"),
    (657, "Robot Return to Origin"), (682, "Baseball Game"),
    (693, "Binary Number with Alternating Bits"), (700, "Search in a Binary Search Tree"),
    (704, "Binary Search"), (709, "To Lower Case"), (728, "Self Dividing Numbers"),
    (771, "Jewels and Stones"), (796, "Rotate String"), (804, "Unique Morse Code Words"),
    (867, "Transpose Matrix"), (908, "Smallest Range I"), (1108, "Defanging an IP Address"),
    (1221, "Split a String in Balanced Strings"),
    (1281, "Subtract the Product and Sum of Digits of an Integer"),
    (1323, "Maximum 69 Number"), (1342, "Number of Steps to Reduce a Number to Zero"),
    (1431, "Kids With the Greatest Number of Candies"),
    (1464, "Maximum Product of Two Elements in an Array"),
    (1470, "Shuffle the Array"), (1480, "Running Sum of 1d Array"),
    (1486, "XOR Operation in an Array"), (1512, "Number of Good Pairs"),
    (1518, "Water Bottles"), (1528, "Shuffle String"), (1544, "Make The String Great"),
    (1550, "Three Consecutive Odds"), (1556, "Thousand Separator"),
    (1572, "Matrix Diagonal Sum"),
    (1614, "Maximum Nesting Depth of the Parentheses"),
    (1619, "Mean of Array After Removing Some Elements"),
    (1636, "Sort Array by Increasing Frequency"),
    (1637, "Widest Vertical Area Between Two Points Containing No Points"),
    (1662, "Check If Two String Arrays are Equivalent"),
    (1672, "Richest Customer Wealth"), (1678, "Goal Parser Interpretation"),
    (1684, "Count the Number of Consistent Strings"),
    (1688, "Count of Matches in Tournament"),
    (1704, "Determine if String Halves Are Alike"),
    (1716, "Calculate Money in Leetcode Bank"), (1720, "Decode XORed Array"),
    (1725, "Number of Rectangles That Can Form The Largest Square"),
    (1732, "Find the Highest Altitude"), (1748, "Sum of Unique Elements"),
    (1752, "Check if Array Is Sorted and Rotated"), (1768, "Merge Strings Alternately"),
    (1773, "Count Items Matching a Rule"),
    (1790, "Check if One String Swap Can Make Strings Equal"),
    (1791, "Find Center of Star Graph"), (1796, "Second Largest Digit in a String"),
    (1800, "Maximum Ascending Subarray Sum"),
    (1805, "Number of Different Integers in a String"),
    (1812, "Determine Color of a Chessboard Square"), (1816, "Truncate Sentence"),
    (1822, "Sign of the Product of an Array"),
    (1827, "Minimum Operations to Make the Array Increasing"),
    (1832, "Check if the Sentence Is Pangram"), (1837, "Sum of Digits in Base K"),
    (1844, "Replace All Digits with Characters"),
    (1848, "Minimum Distance to the Target Element"), (1854, "Maximum Population Year"),
    (1859, "Sorting the Sentence"), (1863, "Sum of All Subset XOR Totals"),
    (1869, "Longer Contiguous Segments of Ones than Zeros"),
    (1876, "Substrings of Size Three with Distinct Characters"),
    (1880, "Check if Word Equals Summation of Two Words"),
    (1886, "Determine Whether Matrix Can Be Obtained By Rotation"),
    (1893, "Check if All the Integers in a Range Are Covered"),
    (1897, "Redistribute Characters to Make All Strings Equal"),
    (1903, "Largest Odd Number in String"),
    (1909, "Remove One Element to Make the Array Strictly Increasing"),
    (1913, "Maximum Product Difference Between Two Pairs"),
    (1920, "Build Array from Permutation"), (1925, "Count Square Sum Triples"),
    (1929, "Concatenation of Array"),
    (1941, "Check if All Characters Have Equal Number of Occurrences"),
    (1945, "Sum of Digits of String After Convert"), (1952, "Three Divisors"),
    (1957, "Delete Characters to Make Fancy String"),
    (1961, "Check if String Is a Prefix of Array"),
    (1974, "Minimum Time to Type Word Using Special Typewriter"),
    (1979, "Find Greatest Common Divisor of Array"),
    (1984, "Minimum Difference Between Highest and Lowest of K Scores"),
    (1991, "Find the Middle Index in Array"), (1995, "Count Special Quadruplets"),
    (2000, "Reverse Prefix of Word"),
    (2006, "Count Number of Pairs With Absolute Difference K"),
    (2011, "Final Value of Variable After Performing Operations"),
    (2022, "Convert 1D Array Into 2D Array"), (2027, "Minimum Moves to Convert String"),
    (2032, "Two Out of Three"), (2037, "Minimum Number of Moves to Seat Everyone"),
    (2042, "Check if Numbers Are Ascending in a Sentence"),
    (2053, "Kth Distinct String in an Array"), (2057, "Smallest Index With Equal Value"),
    (2062, "Count Vowel Substrings of a String"),
    (2068, "Check Whether Two Strings are Almost Equivalent"),
    (2073, "Time Needed to Buy Tickets"),
    (2078, "Two Furthest Houses With Different Colors"),
    (2085, "Count Common Words With One Occurrence"),
    (2089, "Find Target Indices After Sorting Array"),
    (2094, "Finding 3-Digit Even Numbers"),
    (2099, "Find Subsequence of Length K With the Largest Sum"),
    (2103, "Rings and Rods"), (2108, "First Palindrome in an Array"),
    (2114, "Maximum Number of Words Found in Sentences"),
    (2119, "A Number After a Double Reversal"),
    (2124, "Check if All A's Appears Before All B's"), (2129, "Capitalize the Title"),
    (2133, "Check if Every Row and Column Contains All Numbers"),
    (2148, "Count Elements With Strictly Smaller and Greater Elements"),
    (2154, "Keep Multiplying Found Values by Two"),
    (2160, "Minimum Sum of Four Digit Number"),
    (2164, "Sort Even and Odd Indices Independently"),
    (2169, "Count Operations to Obtain Zero"),
    (2176, "Count Equal and Divisible Pairs in an Array"),
    (2180, "Count Integers With Even Digit Sum"),
    (2185, "Counting Words With a Given Prefix"),
    (2190, "Most Frequent Number Following Key In an Array"),
    (2194, "Cells in a Range on an Excel Sheet"),
    (2200, "Find All K-Distant Indices in an Array"),
    (2206, "Divide Array Into Equal Pairs"),
    (2210, "Count Hills and Valleys in an Array"),
    (2215, "Find the Difference of Two Arrays"),
    (2220, "Minimum Bit Flips to Convert Number"),
    (2231, "Largest Number After Digit Swaps by Parity"),
    (2235, "Add Two Integers"), (2236, "Root Equals Sum of Children"),
    (2239, "Find Closest Number to Zero"), (2243, "Calculate Digit Sum of a String"),
    (2248, "Intersection of Multiple Arrays"),
    (2255, "Count Prefixes of a Given String"),
    (2259, "Remove Digit From Number to Maximize Result"),
    (2264, "Largest 3-Same-Digit Number in String"),
    (2269, "Find the K-Beauty of a Number"), (2278, "Percentage of Letter in String"),
    (2283, "Check if Number Has Equal Digit Count and Digit Value"),
    (2293, "Min Max Game"), (2299, "Strong Password Checker II"),
    (2303, "Calculate Amount Paid in Taxes"),
    (2309, "Greatest English Letter in Upper and Lower Case"),
    (2315, "Count Asterisks"), (2319, "Check if Matrix Is X-Matrix"),
    (2325, "Decode the Message"), (2331, "Evaluate Boolean Binary Tree"),
    (2335, "Minimum Amount of Time to Fill Cups"),
    (2341, "Maximum Number of Pairs in Array"), (2347, "Best Poker Hand"),
    (2351, "First Letter to Appear Twice"),
    (2357, "Make Array Zero by Subtracting Equal Amounts"),
    (2363, "Merge Similar Items"), (2367, "Number of Arithmetic Triplets"),
    (2373, "Largest Local Values in a Matrix"),
    (2383, "Minimum Hours of Training to Win a Competition"),
    (2389, "Longest Subsequence With Limited Sum"),
    (2395, "Find Subarrays With Equal Sum"),
    (2399, "Check Distances Between Same Letters"),
    (2404, "Most Frequent Even Element"), (2413, "Smallest Even Multiple"),
    (2418, "Sort the People"), (2427, "Number of Common Factors"),
    (2441, "Largest Positive Integer That Exists With Its Negative"),
    (2446, "Determine if Two Events Have Conflict"),
    (2460, "Apply Operations to an Array"), (2469, "Convert the Temperature"),
    (2475, "Number of Unequal Triplets in Array"),
    (2481, "Minimum Cuts to Divide a Circle"), (2485, "Find the Pivot Integer"),
    (2496, "Maximum Value of a String in an Array"),
    (2500, "Delete Greatest Value in Each Row"),
    (2515, "Shortest Distance to Target String in a Circular Array"),
    (2520, "Count the Digits That Divide a Number"),
    (2525, "Categorize Box According to Criteria"),
    (2529, "Maximum Count of Positive Integer and Negative Integer"),
    (2535, "Difference Between Element Sum and Digit Sum"),
    (2540, "Minimum Common Value"), (2544, "Alternating Digit Sum"),
    (2549, "Count Distinct Numbers on Board"),
    (2553, "Separate the Digits in an Array"),
    (2562, "Find the Array Concatenation Value"),
    (2566, "Maximum Difference by Remapping a Digit"),
    (2574, "Left and Right Sum Differences"), (2582, "Pass the Pillow"),
    (2600, "K Items With the Maximum Sum"),
    (2605, "Form Smallest Number From Two Digit Arrays"),
    (2614, "Prime In Diagonal"), (2639, "Find the Width of Columns of a Grid"),
    (2643, "Row With Maximum Ones"), (2651, "Calculate Delayed Arrival Time"),
    (2652, "Sum Multiples"), (2656, "Maximum Sum With Exactly K Elements"),
    (2660, "Determine the Winner of a Bowling Game"),
    (2670, "Find the Distinct Difference Array"), (2678, "Number of Senior Citizens"),
    (2682, "Find the Losers of the Circular Game"),
    (2696, "Minimum String Length After Removing Substrings"),
    (2697, "Lexicographically Smallest Palindrome"), (2706, "Buy Two Chocolates"),
    (2710, "Remove Trailing Zeros From a String"), (2716, "Minimize String Length"),
    (2729, "Check if Number is Fascinating"), (2733, "Neither Minimum nor Maximum"),
    (2739, "Total Distance Traveled"), (2748, "Number of Beautiful Pairs"),
    (2765, "Longest Alternating Subarray"),
    (2769, "Find the Maximum Achievable Number"),
    (2778, "Sum of Squares of Special Elements"), (2784, "Check if Array is Good"),
    (2788, "Split Strings by Separator"),
    (2798, "Number of Employees Who Met the Target"),
    (2806, "Account Balance After Rounded Purchase"), (2810, "Faulty Keyboard"),
    (2824, "Count Pairs Whose Sum is Less than Target"),
    (2828, "Check if a String Is an Acronym of Words"),
    (2839, "Check if Strings Can be Made Equal With Operations I"),
    (2848, "Points That Intersect With Cars"),
    (2859, "Sum of Values at Indices With K Set Bits"),
    (2864, "Maximum Odd Binary Number"),
    (2894, "Divisible and Non-divisible Sums Difference"),
    (2903, "Find Indices With Index and Value Difference I"),
    (2908, "Minimum Sum of Mountain Triplets I"), (2923, "Find Champion I"),
    (2928, "Distribute Candies Among Children I"),
    (2942, "Find Words Containing Character"), (2951, "Find the Peaks"),
    (2956, "Find Common Elements Between Two Arrays"),
    (2960, "Count Tested Devices After Test Operations"),
    (2965, "Missing and Repeated Values"),
    (2970, "Count the Number of Incremovable Subarrays I"),
    (2974, "Minimum Number Game"),
    (2980, "Check if Bitwise OR Has Trailing Zeros"),
    (2996, "Smallest Missing Integer Greater Than Sequential Prefix Sum"),
    (3000, "Maximum Area of Longest Diagonal Rectangle"),
    (3005, "Maximum Frequency Elements"),
    (3010, "Divide an Array Into Subarrays With Minimum Cost I"),
    (3014, "Minimum Number of Pushes to Type Word I"),
    (3019, "Number of Changing Keys"), (3024, "Type of Triangle"),
    (3028, "Ant on the Boundary"), (3033, "Modify the Matrix"),
    (3038, "Maximum Number of Operations With the Same Score I"),
    (3042, "Count Prefix and Suffix Pairs I"), (3046, "Split the Array"),
    (3065, "Minimum Operations to Exceed Threshold Value I"),
    (3069, "Distribute Elements Into Two Arrays I"),
    (3079, "Find the Sum of Encrypted Integers"), (3099, "Harshad Number"),
    (3110, "Score of a String"), (3127, "Make a Square with the Same Color"),
    (3131, "Find the Integer Added to Array I"),
    (3146, "Permutation Difference between Two Strings"),
    (3151, "Special Array I"),
    (3158, "Find the XOR of Numbers Which Appear Twice"),
    (3162, "Find the Number of Good Pairs I"),
    (3168, "Minimum Number of Chairs in a Waiting Room"),
    (3184, "Count Pairs That Form a Complete Day I"),
    (3190, "Find Minimum Operations to Make All Elements Divisible by Three"),
    (3222, "Find the Winning Player in Coin Game"),
    (3270, "Find the Key of the Numbers"), (3280, "Convert Date to Binary"),
    (3285, "Find Indices of Stable Mountains"),
    (3289, "The Two Sneaky Numbers of Digitville"),
]

def get_solved_problem_ids():
    """Scan repository directories to find which problem IDs have solutions."""
    solved = set()
    repo_path = Path('.')
    pattern = re.compile(r'^(\d{4})-')
    for item in repo_path.iterdir():
        if item.is_dir():
            match = pattern.match(item.name)
            if match:
                solved.add(int(match.group(1)))
    return solved


def generate_checklist_html(solved_ids):
    """Generate the Easy Problems Checklist HTML page."""
    total = len(EASY_PROBLEMS)
    done = sum(1 for pid, _ in EASY_PROBLEMS if pid in solved_ids)

    rows = ''
    for pid, name in EASY_PROBLEMS:
        is_done = pid in solved_ids
        icon = '✅' if is_done else '⬜'
        status_class = 'done' if is_done else 'pending'
        lc_slug = name.lower().replace(' ', '-').replace('(', '').replace(')', '').replace(',', '').replace("'", '')
        lc_url = f'https://leetcode.com/problems/{lc_slug}'
        folder = None
        if is_done:
            padded = str(pid).zfill(4)
            # find matching directory
            repo_path = Path('.')
            for item in repo_path.iterdir():
                if item.is_dir() and item.name.startswith(padded + '-'):
                    folder = item.name
                    break
        code_link = ''
        if folder:
            code_link = f'<a href="https://github.com/devxoshakya/leetcode/tree/master/{folder}" class="code-link" target="_blank">View Code</a>'

        rows += f'''
            <tr class="checklist-row {status_class}">
                <td class="status-cell">{icon}</td>
                <td class="id-cell">{pid}</td>
                <td class="name-cell"><a href="{lc_url}" target="_blank">{name}</a></td>
                <td class="link-cell">{code_link}</td>
            </tr>'''

    html = f'''<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Easy Problems Checklist - LeetCode Solutions</title>
    <style>
        * {{ margin: 0; padding: 0; box-sizing: border-box; }}
        body {{
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }}
        .container {{
            max-width: 1000px;
            margin: 0 auto;
            background: white;
            border-radius: 12px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }}
        header {{
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 40px;
            text-align: center;
        }}
        header h1 {{ font-size: 2.2em; margin-bottom: 10px; }}
        header p {{ font-size: 1.1em; opacity: 0.9; }}
        nav {{
            background: rgba(255,255,255,0.15);
            padding: 12px 0;
            margin-top: 20px;
            border-radius: 8px;
        }}
        nav a {{
            color: white;
            text-decoration: none;
            padding: 8px 20px;
            border-radius: 6px;
            margin: 0 5px;
            transition: background 0.3s;
            font-weight: 500;
        }}
        nav a:hover {{ background: rgba(255,255,255,0.2); }}
        nav a.active {{ background: rgba(255,255,255,0.25); }}
        .progress-section {{
            padding: 30px 40px;
            background: #f8f9fa;
            border-bottom: 1px solid #e9ecef;
        }}
        .progress-stats {{
            display: flex;
            justify-content: center;
            gap: 30px;
            margin-bottom: 20px;
            flex-wrap: wrap;
        }}
        .progress-stat {{
            text-align: center;
            padding: 15px 25px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }}
        .progress-stat .number {{
            font-size: 2em;
            font-weight: bold;
            color: #667eea;
        }}
        .progress-stat .label {{
            color: #6c757d;
            font-size: 0.85em;
            text-transform: uppercase;
            letter-spacing: 1px;
        }}
        .progress-bar-container {{
            background: #e9ecef;
            border-radius: 10px;
            height: 20px;
            overflow: hidden;
            max-width: 500px;
            margin: 0 auto;
        }}
        .progress-bar {{
            height: 100%;
            background: linear-gradient(90deg, #00b8a3, #667eea);
            border-radius: 10px;
            transition: width 0.5s;
        }}
        .filters {{
            padding: 15px 40px;
            background: #f8f9fa;
            border-bottom: 1px solid #e9ecef;
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
            align-items: center;
        }}
        .filter-label {{ font-weight: 600; color: #495057; }}
        .filter-btn {{
            padding: 8px 16px;
            border: 2px solid #dee2e6;
            background: white;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.3s;
            font-size: 0.9em;
        }}
        .filter-btn:hover {{ border-color: #667eea; color: #667eea; }}
        .filter-btn.active {{ background: #667eea; color: white; border-color: #667eea; }}
        .search-box {{ flex: 1; min-width: 200px; }}
        .search-box input {{
            width: 100%;
            padding: 10px 15px;
            border: 2px solid #dee2e6;
            border-radius: 6px;
            font-size: 0.95em;
        }}
        .search-box input:focus {{ outline: none; border-color: #667eea; }}
        .checklist-table {{
            width: 100%;
            border-collapse: collapse;
        }}
        .checklist-table thead {{
            background: #f8f9fa;
            position: sticky;
            top: 0;
        }}
        .checklist-table th {{
            padding: 14px 20px;
            text-align: left;
            font-weight: 600;
            color: #495057;
            border-bottom: 2px solid #dee2e6;
            font-size: 0.9em;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }}
        .checklist-table td {{
            padding: 12px 20px;
            border-bottom: 1px solid #f0f0f0;
        }}
        .checklist-row {{ transition: background 0.2s; }}
        .checklist-row:hover {{ background: #f8f9fa; }}
        .checklist-row.done {{ background: #f0fdf4; }}
        .checklist-row.done:hover {{ background: #dcfce7; }}
        .status-cell {{ text-align: center; font-size: 1.2em; width: 60px; }}
        .id-cell {{ font-weight: 600; color: #667eea; width: 70px; }}
        .name-cell a {{ color: #212529; text-decoration: none; font-weight: 500; }}
        .name-cell a:hover {{ color: #667eea; }}
        .link-cell {{ width: 120px; text-align: center; }}
        .code-link {{
            padding: 5px 12px;
            background: #24292e;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 0.8em;
            transition: background 0.3s;
        }}
        .code-link:hover {{ background: #1a1f23; }}
        .table-container {{
            padding: 0 40px 40px;
            overflow-x: auto;
        }}
        footer {{
            text-align: center;
            padding: 30px;
            background: #f8f9fa;
            color: #6c757d;
            border-top: 1px solid #e9ecef;
        }}
        footer a {{ color: #667eea; text-decoration: none; }}
        footer a:hover {{ text-decoration: underline; }}
        @media (max-width: 768px) {{
            header h1 {{ font-size: 1.6em; }}
            .checklist-table td, .checklist-table th {{ padding: 10px 12px; }}
            .table-container {{ padding: 0 15px 20px; }}
            .progress-section {{ padding: 20px 15px; }}
            .filters {{ padding: 15px; }}
        }}
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>📋 Easy Problems Checklist</h1>
            <p>Track progress on {total} LeetCode Easy problems</p>
            <nav>
                <a href="index.html">🎯 Solutions</a>
                <a href="checklist.html" class="active">📋 Checklist</a>
            </nav>
        </header>

        <div class="progress-section">
            <div class="progress-stats">
                <div class="progress-stat">
                    <div class="number">{done}</div>
                    <div class="label">Completed</div>
                </div>
                <div class="progress-stat">
                    <div class="number">{total - done}</div>
                    <div class="label">Remaining</div>
                </div>
                <div class="progress-stat">
                    <div class="number">{total}</div>
                    <div class="label">Total</div>
                </div>
            </div>
            <div class="progress-bar-container">
                <div class="progress-bar" style="width: {done * 100 / total:.1f}%"></div>
            </div>
        </div>

        <div class="filters">
            <span class="filter-label">Show:</span>
            <button class="filter-btn active" data-filter="all">All ({total})</button>
            <button class="filter-btn" data-filter="done">Done ({done})</button>
            <button class="filter-btn" data-filter="pending">Pending ({total - done})</button>
            <div class="search-box">
                <input type="text" id="searchInput" placeholder="Search problems...">
            </div>
        </div>

        <div class="table-container">
            <table class="checklist-table">
                <thead>
                    <tr>
                        <th>Status</th>
                        <th>ID</th>
                        <th>Problem Name</th>
                        <th>Code</th>
                    </tr>
                </thead>
                <tbody id="checklistBody">
                    {rows}
                </tbody>
            </table>
        </div>

        <footer>
            <p>Auto-updated on {datetime.now().strftime("%B %d, %Y")} &bull; Checkmarks update automatically when solutions are committed</p>
            <p>View the repository on <a href="https://github.com/devxoshakya/leetcode" target="_blank">GitHub</a></p>
        </footer>
    </div>

    <script>
        const filterBtns = document.querySelectorAll('.filter-btn');
        const rows = document.querySelectorAll('.checklist-row');
        const searchInput = document.getElementById('searchInput');
        let currentFilter = 'all';
        let searchTerm = '';

        filterBtns.forEach(btn => {{
            btn.addEventListener('click', () => {{
                filterBtns.forEach(b => b.classList.remove('active'));
                btn.classList.add('active');
                currentFilter = btn.dataset.filter;
                applyFilters();
            }});
        }});

        searchInput.addEventListener('input', (e) => {{
            searchTerm = e.target.value.toLowerCase();
            applyFilters();
        }});

        function applyFilters() {{
            rows.forEach(row => {{
                const isDone = row.classList.contains('done');
                const text = row.textContent.toLowerCase();
                const matchesFilter = currentFilter === 'all' ||
                    (currentFilter === 'done' && isDone) ||
                    (currentFilter === 'pending' && !isDone);
                const matchesSearch = searchTerm === '' || text.includes(searchTerm);
                row.style.display = (matchesFilter && matchesSearch) ? '' : 'none';
            }});
        }}
    </script>
</body>
</html>'''
    return html


def parse_readme(readme_path):
    """Parse a problem's README.md to extract details."""
    try:
        with open(readme_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # Extract problem title and difficulty
        match = re.search(r'<h2><a href="([^"]+)">(\d+)\.\s*([^<]+)</a></h2><h3>(\w+)</h3>', content)
        if match:
            url, number, title, difficulty = match.groups()
            return {
                'number': int(number),
                'title': title,
                'difficulty': difficulty,
                'url': url
            }
    except Exception as e:
        print(f"Error parsing {readme_path}: {e}")
    
    return None

def get_solution_files(problem_dir):
    """Get list of solution files in a problem directory."""
    solutions = []
    for file in problem_dir.iterdir():
        if file.is_file() and file.suffix in ['.java', '.py', '.cpp', '.js', '.go', '.ts']:
            solutions.append(file.name)
    return solutions

def scan_repository():
    """Scan repository for all LeetCode problems."""
    problems = []
    repo_path = Path('.')
    
    # Pattern to match problem directories (e.g., 0001-two-sum)
    pattern = re.compile(r'^\d{4}-')
    
    for item in repo_path.iterdir():
        if item.is_dir() and pattern.match(item.name):
            readme_path = item / 'README.md'
            if readme_path.exists():
                problem_data = parse_readme(readme_path)
                if problem_data:
                    problem_data['folder'] = item.name
                    problem_data['solutions'] = get_solution_files(item)
                    problems.append(problem_data)
    
    # Sort by problem number
    problems.sort(key=lambda x: x['number'])
    return problems

def generate_html(problems):
    """Generate HTML page from problems data."""
    
    difficulty_colors = {
        'Easy': '#00b8a3',
        'Medium': '#ffc01e',
        'Hard': '#ff375f'
    }
    
    difficulty_counts = {'Easy': 0, 'Medium': 0, 'Hard': 0}
    for p in problems:
        difficulty_counts[p['difficulty']] += 1
    
    total_problems = len(problems)
    
    html = f"""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LeetCode Solutions - devxoshakya</title>
    <style>
        * {{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }}
        
        body {{
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }}
        
        .container {{
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 12px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }}
        
        header {{
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 40px;
            text-align: center;
        }}
        
        header h1 {{
            font-size: 2.5em;
            margin-bottom: 10px;
        }}
        
        header p {{
            font-size: 1.2em;
            opacity: 0.9;
        }}
        
        .stats {{
            display: flex;
            justify-content: space-around;
            padding: 30px;
            background: #f8f9fa;
            border-bottom: 1px solid #e9ecef;
        }}
        
        .stat-card {{
            text-align: center;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            min-width: 150px;
        }}
        
        .stat-number {{
            font-size: 2.5em;
            font-weight: bold;
            margin-bottom: 10px;
        }}
        
        .stat-label {{
            color: #6c757d;
            font-size: 0.9em;
            text-transform: uppercase;
            letter-spacing: 1px;
        }}
        
        .filters {{
            padding: 20px 40px;
            background: #f8f9fa;
            border-bottom: 1px solid #e9ecef;
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
            align-items: center;
        }}
        
        .filter-label {{
            font-weight: 600;
            color: #495057;
        }}
        
        .filter-btn {{
            padding: 8px 16px;
            border: 2px solid #dee2e6;
            background: white;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.3s;
            font-size: 0.9em;
        }}
        
        .filter-btn:hover {{
            border-color: #667eea;
            color: #667eea;
        }}
        
        .filter-btn.active {{
            background: #667eea;
            color: white;
            border-color: #667eea;
        }}
        
        .search-box {{
            flex: 1;
            min-width: 250px;
        }}
        
        .search-box input {{
            width: 100%;
            padding: 10px 15px;
            border: 2px solid #dee2e6;
            border-radius: 6px;
            font-size: 0.95em;
        }}
        
        .search-box input:focus {{
            outline: none;
            border-color: #667eea;
        }}
        
        .problems-list {{
            padding: 20px 40px 40px;
        }}
        
        .problem-card {{
            background: white;
            border: 1px solid #e9ecef;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 15px;
            transition: all 0.3s;
            display: flex;
            align-items: center;
            gap: 20px;
        }}
        
        .problem-card:hover {{
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            transform: translateY(-2px);
        }}
        
        .problem-number {{
            font-size: 1.5em;
            font-weight: bold;
            color: #667eea;
            min-width: 60px;
        }}
        
        .problem-info {{
            flex: 1;
        }}
        
        .problem-title {{
            font-size: 1.2em;
            font-weight: 600;
            color: #212529;
            margin-bottom: 8px;
        }}
        
        .problem-title a {{
            color: inherit;
            text-decoration: none;
        }}
        
        .problem-title a:hover {{
            color: #667eea;
        }}
        
        .problem-meta {{
            display: flex;
            gap: 15px;
            align-items: center;
            flex-wrap: wrap;
        }}
        
        .difficulty-badge {{
            padding: 4px 12px;
            border-radius: 4px;
            font-size: 0.85em;
            font-weight: 600;
            color: white;
        }}
        
        .solutions {{
            display: flex;
            gap: 8px;
            flex-wrap: wrap;
        }}
        
        .solution-badge {{
            padding: 4px 10px;
            background: #e9ecef;
            border-radius: 4px;
            font-size: 0.8em;
            color: #495057;
        }}
        
        .github-link {{
            padding: 8px 16px;
            background: #24292e;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 0.9em;
            transition: background 0.3s;
        }}
        
        .github-link:hover {{
            background: #1a1f23;
        }}
        
        footer {{
            text-align: center;
            padding: 30px;
            background: #f8f9fa;
            color: #6c757d;
            border-top: 1px solid #e9ecef;
        }}
        
        footer a {{
            color: #667eea;
            text-decoration: none;
        }}
        
        footer a:hover {{
            text-decoration: underline;
        }}
        
        .no-results {{
            text-align: center;
            padding: 60px 20px;
            color: #6c757d;
        }}
        
        .no-results h3 {{
            font-size: 1.5em;
            margin-bottom: 10px;
        }}
        
        @media (max-width: 768px) {{
            .stats {{
                flex-direction: column;
                gap: 15px;
            }}
            
            .problem-card {{
                flex-direction: column;
                align-items: flex-start;
            }}
            
            header h1 {{
                font-size: 1.8em;
            }}
            
            .problems-list {{
                padding: 20px;
            }}
        }}
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>🎯 LeetCode Solutions</h1>
            <p>My journey through coding challenges</p>
            <nav style="background:rgba(255,255,255,0.15);padding:12px 0;margin-top:20px;border-radius:8px;">
                <a href="index.html" style="color:white;text-decoration:none;padding:8px 20px;border-radius:6px;margin:0 5px;font-weight:500;background:rgba(255,255,255,0.25);">🎯 Solutions</a>
                <a href="checklist.html" style="color:white;text-decoration:none;padding:8px 20px;border-radius:6px;margin:0 5px;font-weight:500;" onmouseover="this.style.background='rgba(255,255,255,0.2)'" onmouseout="this.style.background='transparent'">📋 Checklist</a>
            </nav>
        </header>
        
        <div class="stats">
            <div class="stat-card">
                <div class="stat-number">{total_problems}</div>
                <div class="stat-label">Total Problems</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" style="color: {difficulty_colors['Easy']}">{difficulty_counts['Easy']}</div>
                <div class="stat-label">Easy</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" style="color: {difficulty_colors['Medium']}">{difficulty_counts['Medium']}</div>
                <div class="stat-label">Medium</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" style="color: {difficulty_colors['Hard']}">{difficulty_counts['Hard']}</div>
                <div class="stat-label">Hard</div>
            </div>
        </div>
        
        <div class="filters">
            <span class="filter-label">Filter:</span>
            <button class="filter-btn active" data-filter="all">All</button>
            <button class="filter-btn" data-filter="Easy">Easy</button>
            <button class="filter-btn" data-filter="Medium">Medium</button>
            <button class="filter-btn" data-filter="Hard">Hard</button>
            <div class="search-box">
                <input type="text" id="searchInput" placeholder="Search problems...">
            </div>
        </div>
        
        <div class="problems-list" id="problemsList">
"""
    
    # Add problem cards
    for problem in problems:
        difficulty_color = difficulty_colors.get(problem['difficulty'], '#6c757d')
        solutions_html = ''.join([f'<span class="solution-badge">{s}</span>' for s in problem['solutions']])
        
        html += f"""
            <div class="problem-card" data-difficulty="{problem['difficulty']}">
                <div class="problem-number">#{problem['number']}</div>
                <div class="problem-info">
                    <div class="problem-title">
                        <a href="{problem['url']}" target="_blank">{problem['title']}</a>
                    </div>
                    <div class="problem-meta">
                        <span class="difficulty-badge" style="background: {difficulty_color}">{problem['difficulty']}</span>
                        <div class="solutions">
                            {solutions_html}
                        </div>
                    </div>
                </div>
                <a href="https://github.com/devxoshakya/leetcode/tree/master/{problem['folder']}" 
                   class="github-link" target="_blank">View Code</a>
            </div>
"""
    
    html += """
        </div>
        
        <footer>
            <p>Generated on """ + datetime.now().strftime("%B %d, %Y") + """</p>
            <p>View the repository on <a href="https://github.com/devxoshakya/leetcode" target="_blank">GitHub</a></p>
        </footer>
    </div>
    
    <script>
        // Filter functionality
        const filterBtns = document.querySelectorAll('.filter-btn');
        const problemCards = document.querySelectorAll('.problem-card');
        const searchInput = document.getElementById('searchInput');
        
        let currentFilter = 'all';
        let searchTerm = '';
        
        filterBtns.forEach(btn => {
            btn.addEventListener('click', () => {
                filterBtns.forEach(b => b.classList.remove('active'));
                btn.classList.add('active');
                currentFilter = btn.dataset.filter;
                applyFilters();
            });
        });
        
        searchInput.addEventListener('input', (e) => {
            searchTerm = e.target.value.toLowerCase();
            applyFilters();
        });
        
        function applyFilters() {
            let visibleCount = 0;
            
            problemCards.forEach(card => {
                const difficulty = card.dataset.difficulty;
                const text = card.textContent.toLowerCase();
                
                const matchesFilter = currentFilter === 'all' || difficulty === currentFilter;
                const matchesSearch = searchTerm === '' || text.includes(searchTerm);
                
                if (matchesFilter && matchesSearch) {
                    card.style.display = 'flex';
                    visibleCount++;
                } else {
                    card.style.display = 'none';
                }
            });
            
            // Show no results message
            const noResults = document.querySelector('.no-results');
            if (noResults) {
                noResults.remove();
            }
            
            if (visibleCount === 0) {
                const problemsList = document.getElementById('problemsList');
                const div = document.createElement('div');
                div.className = 'no-results';
                div.innerHTML = '<h3>No problems found</h3><p>Try adjusting your filters or search term.</p>';
                problemsList.appendChild(div);
            }
        }
    </script>
</body>
</html>
"""
    
    return html

def main():
    """Main function to generate the GitHub Pages site."""
    print("Scanning repository for LeetCode problems...")
    problems = scan_repository()
    print(f"Found {len(problems)} problems")
    
    print("Generating HTML...")
    html = generate_html(problems)
    
    # Create docs directory
    docs_dir = Path('docs')
    docs_dir.mkdir(exist_ok=True)
    
    # Write main HTML file
    output_path = docs_dir / 'index.html'
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write(html)
    print(f"✓ Generated {output_path}")

    # Generate Easy Problems Checklist page
    print("Generating Easy Problems Checklist...")
    solved_ids = get_solved_problem_ids()
    checklist_html = generate_checklist_html(solved_ids)
    checklist_path = docs_dir / 'checklist.html'
    with open(checklist_path, 'w', encoding='utf-8') as f:
        f.write(checklist_html)
    done_count = sum(1 for pid, _ in EASY_PROBLEMS if pid in solved_ids)
    print(f"✓ Generated {checklist_path} ({done_count}/{len(EASY_PROBLEMS)} completed)")

    print("Done!")

if __name__ == '__main__':
    main()
