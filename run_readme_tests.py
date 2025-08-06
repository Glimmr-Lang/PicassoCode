#!/usr/bin/env python3
"""
Simple test runner for README validation tests.
Run this script to execute all README-related tests.
"""

import subprocess
import sys
import os

def main():
    """Run the README validation tests."""
    try:
        # Change to the repository root directory
        repo_root = os.path.dirname(os.path.abspath(__file__))
        os.chdir(repo_root)
        
        # Run pytest with verbose output
        result = subprocess.run([
            sys.executable, "-m", "pytest", 
            "tests/test_readme_validation.py", 
            "-v", "--tb=short"
        ], capture_output=False)
        
        return result.returncode
        
    except FileNotFoundError:
        print("Error: pytest not found. Please install pytest:")
        print("pip install -r requirements-test.txt")
        return 1
    except Exception as e:
        print(f"Error running tests: {e}")
        return 1

if __name__ == "__main__":
    sys.exit(main())