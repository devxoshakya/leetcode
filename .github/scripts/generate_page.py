#!/usr/bin/env python3
"""
Generate GitHub Pages HTML for LeetCode solutions.
"""
import os
import re
import json
from pathlib import Path
from datetime import datetime

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
    
    # Write HTML file
    output_path = docs_dir / 'index.html'
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write(html)
    
    print(f"✓ Generated {output_path}")
    print("Done!")

if __name__ == '__main__':
    main()
