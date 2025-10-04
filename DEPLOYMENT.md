# GitHub Pages Deployment Guide

This repository includes a GitHub Actions workflow that automatically generates and deploys a beautiful GitHub Pages site showcasing all your LeetCode solutions.

## ✨ Features

- **Automatic Updates**: The page is automatically regenerated whenever you push to the main/master branch
- **Problem Statistics**: Shows total problems solved and breakdown by difficulty (Easy, Medium, Hard)
- **Search & Filter**: Visitors can search for specific problems and filter by difficulty
- **Responsive Design**: Works great on desktop and mobile devices
- **Direct Links**: Each problem links to LeetCode and your solution code on GitHub

## 🚀 Setup Instructions

To enable GitHub Pages for your repository, follow these steps:

### 1. Enable GitHub Pages

1. Go to your repository on GitHub: https://github.com/devxoshakya/leetcode
2. Click on **Settings** (top menu bar)
3. Scroll down to the **Pages** section in the left sidebar
4. Under **Source**, select **GitHub Actions**
5. Click **Save**

### 2. Trigger the Workflow

The workflow will run automatically when:
- You push changes to the `main` or `master` branch
- You manually trigger it from the Actions tab

To manually trigger it:
1. Go to the **Actions** tab in your repository
2. Click on **Deploy GitHub Pages** workflow
3. Click **Run workflow**
4. Select the branch and click **Run workflow**

### 3. Access Your Page

After the workflow completes successfully (usually takes 1-2 minutes):
- Your GitHub Pages site will be available at: `https://devxoshakya.github.io/leetcode/`

## 📁 Files Added

- `.github/workflows/gh-pages.yml` - GitHub Actions workflow configuration
- `.github/scripts/generate_page.py` - Python script that generates the HTML page
- `.gitignore` - Excludes the `docs/` folder from version control

## 🔧 How It Works

1. The workflow is triggered on push to main/master or manually
2. It checks out your repository code
3. Runs the Python script to scan all problem directories
4. Generates a beautiful HTML page with all your solutions
5. Deploys the page to GitHub Pages

## 🎨 Customization

You can customize the generated page by editing `.github/scripts/generate_page.py`:

- **Colors**: Modify the `difficulty_colors` dictionary
- **Styling**: Update the CSS in the `generate_html()` function
- **Content**: Change the header text, footer, or add more information

## 📊 What Gets Displayed

For each LeetCode problem, the page shows:
- Problem number and title
- Difficulty level (Easy/Medium/Hard)
- Link to the problem on LeetCode
- Link to your solution code on GitHub
- Programming languages used in your solutions

## 🐛 Troubleshooting

If the workflow fails:
1. Check the **Actions** tab for error messages
2. Ensure your problem directories follow the format: `0001-problem-name`
3. Verify that each problem has a `README.md` file

If the page doesn't update:
1. Make sure GitHub Pages is enabled in Settings
2. Check that the workflow ran successfully
3. Wait a few minutes for GitHub Pages to propagate changes

## 📝 Note

The `docs/` folder is generated automatically by the workflow and is excluded from git (via `.gitignore`). You don't need to commit or maintain it manually.

Enjoy showcasing your LeetCode journey! 🎯
