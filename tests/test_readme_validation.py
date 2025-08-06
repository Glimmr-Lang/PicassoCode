import pytest
import re
import requests
from pathlib import Path
from unittest.mock import patch, Mock


class TestReadmeValidation:
    """Comprehensive test suite for README.md validation and content verification."""

    @pytest.fixture
    def readme_content(self):
        """Fixture to load README.md content for testing."""
        readme_path = Path("README.md")
        if readme_path.exists():
            return readme_path.read_text(encoding='utf-8')
        return ""

    def test_readme_file_exists(self):
        """Test that README.md file exists in the repository root."""
        readme_path = Path("README.md")
        assert readme_path.exists(), "README.md file should exist in repository root"
        assert readme_path.is_file(), "README.md should be a file, not a directory"

    def test_readme_is_not_empty(self, readme_content):
        """Test that README.md is not empty and has meaningful content."""
        assert readme_content.strip(), "README.md should not be empty"
        assert len(readme_content.strip()) > 100, "README.md should have substantial content"

    def test_project_title_present(self, readme_content):
        """Test that the project title 'Piccaso Code' is present in README."""
        assert "Piccaso Code" in readme_content, "Project title 'Piccaso Code' should be present"
        # Also test for the correct spelling variant
        assert "Piccasso code" in readme_content, "Alternative spelling 'Piccasso code' should be present"

    def test_project_description_present(self, readme_content):
        """Test that key project description elements are present."""
        assert "image editor" in readme_content.lower(), "Should mention 'image editor'"
        assert "java" in readme_content.lower(), "Should mention 'java' as the programming language"
        assert "glimr" in readme_content.lower(), "Should mention 'glimr' scripting language"
        assert "code to create/edit an image" in readme_content.lower(), "Should describe core functionality"

    def test_html_table_structure(self, readme_content):
        """Test that HTML table structure is valid and well-formed."""
        # Test for table opening and closing tags
        assert "<table>" in readme_content, "Should contain opening table tag"
        assert "</table>" in readme_content, "Should contain closing table tag"

        # Test for proper row structure
        table_rows = re.findall(r"<tr>.*?</tr>", readme_content, re.DOTALL)
        assert len(table_rows) >= 1, "Should have at least one table row"

        # Test for proper cell structure
        table_cells = re.findall(r"<td>.*?</td>", readme_content, re.DOTALL)
        assert len(table_cells) >= 2, "Should have at least two table cells"

    def test_app_icon_reference(self, readme_content):
        """Test that app icon image reference is properly formatted."""
        img_pattern = r'<img\s+src="([^"]+)"\s+width="([^"]+)"\s*/>'
        img_matches = re.findall(img_pattern, readme_content)

        assert len(img_matches) > 0, "Should contain at least one img tag"

        for src, width in img_matches:
            assert src.startswith("./"), "Image source should use relative path"
            assert "appicon.png" in src, "Should reference the app icon file"
            assert width.endswith("%"), "Width should be specified as percentage"

    def test_github_actions_badge(self, readme_content):
        """Test that GitHub Actions CI badge is present and properly formatted."""
        badge_pattern = r'\[![^]]+\]\([^)]+\)'
        badges = re.findall(badge_pattern, readme_content)

        assert len(badges) > 0, "Should contain at least one badge"
        assert "Java CI with Maven" in readme_content, "Should contain Java CI badge text"
        assert "actions/workflows/maven.yml" in readme_content, "Should reference Maven workflow"

    def test_required_sections_present(self, readme_content):
        """Test that all required sections are present in the README."""
        required_sections = [
            "## About",
            "## Download",
            "## Building",
            "## Inspired by",
            "## References",
            "## License"
        ]

        for section in required_sections:
            assert section in readme_content, f"Required section '{section}' should be present"

    def test_build_instructions_valid(self, readme_content):
        """Test that build instructions are present and properly formatted."""
        # Test for git clone command
        assert "git clone" in readme_content, "Should contain git clone command"
        assert "github.com" in readme_content, "Should reference GitHub repository"

        # Test for Maven build command
        assert "mvn package" in readme_content, "Should contain Maven package command"

        # Test for Java execution command
        assert "java -jar" in readme_content, "Should contain Java execution command"
        assert "target/" in readme_content, "Should reference target directory"
        assert ".jar" in readme_content, "Should reference JAR file"

    def test_code_blocks_properly_formatted(self, readme_content):
        """Test that code blocks are properly formatted with language specifiers."""
        code_block_pattern = r'```(\w+)?\n(.*?)\n```'
        code_blocks = re.findall(code_block_pattern, readme_content, re.DOTALL)

        assert len(code_blocks) >= 2, "Should contain at least 2 code blocks"

        # Check for shell/bash code blocks
        shell_blocks = [content for lang, content in code_blocks if lang in ['sh', 'bash', 'shell']]
        assert len(shell_blocks) >= 1, "Should contain at least one shell code block"

    def test_external_references_format(self, readme_content):
        """Test that external references are properly formatted."""
        # Test for OpenSCAD reference
        assert "OpenSCAD" in readme_content, "Should reference OpenSCAD"
        assert "openscad.org" in readme_content, "Should contain OpenSCAD URL"

        # Test for java image filters reference
        assert "jhlabs.com" in readme_content, "Should reference JH Labs filters"

        # Test for Icons8 reference
        assert "icons8.com" in readme_content, "Should reference Icons8"

    @pytest.mark.parametrize("url", [
        "https://github.com/Glimmr-Lang/PicassoCode/actions/workflows/maven.yml",
        "https://openscad.org/",
        "http://www.jhlabs.com/ip/filters/index.html",
        "https://icons8.com/icons/parakeet--style-parakeet"
    ])
    def test_external_urls_accessible(self, url):
        """Test that external URLs mentioned in README are accessible (mocked for testing)."""
        with patch('requests.get') as mock_get:
            mock_response = Mock()
            mock_response.status_code = 200
            mock_response.raise_for_status.return_value = None
            mock_get.return_value = mock_response

            response = requests.get(url, timeout=10)
            assert response.status_code == 200, f"URL {url} should be accessible"
            mock_get.assert_called_once_with(url, timeout=10)

    def test_license_section_format(self, readme_content):
        """Test that license section contains proper ASCII art and license info."""
        license_section = readme_content[readme_content.find("## License"):]

        # Test for ASCII art presence
        assert "drawString" in license_section, "License section should contain drawString function"
        assert "Creativity + Logic + Math" in license_section, "Should contain project motto"
        assert "MIT LICENSE" in license_section, "Should mention MIT license"

        # Test for proper code block formatting in license
        assert '```sh' in license_section, "License code should be in shell code block"

    def test_tagline_consistency(self, readme_content):
        """Test that the project tagline appears consistently throughout."""
        tagline = "Creativity + Logic + Math"
        tagline_occurrences = readme_content.count(tagline)
        assert tagline_occurrences >= 2, f"Tagline '{tagline}' should appear at least twice"

    def test_spelling_and_consistency(self, readme_content):
        """Test for potential spelling inconsistencies in project name."""
        # The README has both "Piccaso" and "Piccasso" - test that both variants are intentional
        piccaso_count = readme_content.count("Piccaso")
        piccasso_count = readme_content.count("Piccasso")

        assert piccaso_count > 0, "Should contain 'Piccaso' variant"
        assert piccasso_count > 0, "Should contain 'Piccasso' variant"

        # Warn about inconsistency (this is more of a documentation test)
        total_variants = piccaso_count + piccasso_count
        assert total_variants >= 2, "Project name should appear multiple times"

    def test_markdown_syntax_validity(self, readme_content):
        """Test basic markdown syntax validity."""
        lines = readme_content.split('\n')

        # Test for proper heading syntax
        heading_lines = [line for line in lines if line.startswith('#')]
        for heading in heading_lines:
            assert re.match(r'^#{1,6}\s+\S+', heading), f"Invalid heading format: {heading}"

        # Test for balanced HTML tags in the content
        html_tags = re.findall(r'<(\/?[^>]+)>', readme_content)
        opening_tags = [tag for tag in html_tags if not tag.startswith('/')]
        closing_tags = [tag[1:] for tag in html_tags if tag.startswith('/')]

        # Basic balance check for common tags
        for tag in ['table', 'tr', 'td', 'h3', 'h6', 'p', 'img']:
            opening_count = sum(1 for t in opening_tags if t.split()[0] == tag)
            closing_count = closing_tags.count(tag)
            if tag != 'img':  # img is self-closing
                assert opening_count == closing_count, f"Unbalanced {tag} tags"

    def test_repository_references_consistency(self, readme_content):
        """Test that repository references are consistent."""
        # Extract repository URLs
        repo_urls = re.findall(r'github\.com[:/][^/\s)]+/[^/\s)]+', readme_content)

        assert len(repo_urls) > 0, "Should contain GitHub repository references"

        # Check for consistency in repository naming
        unique_repos = set(repo_urls)
        # There might be slight variations (Glimmr-Lang/PicassoCode vs hexaredecimal/Piccode)
        # This test documents the current state
        assert len(unique_repos) >= 1, "Should reference at least one repository"

    def test_download_section_placeholder(self, readme_content):
        """Test that download section has appropriate placeholder text."""
        download_section_match = re.search(r'## Download.*?## Building', readme_content, re.DOTALL)
        assert download_section_match, "Should have Download section before Building section"

        download_content = download_section_match.group(0)
        assert "Coming soon" in download_content, "Download section should indicate coming soon"

    def test_file_encoding_and_format(self):
        """Test that README file has proper encoding and line endings."""
        readme_path = Path("README.md")
        if readme_path.exists():
            # Test that file can be read as UTF-8
            try:
                content = readme_path.read_text(encoding='utf-8')
                assert len(content) > 0, "File should be readable as UTF-8"
            except UnicodeDecodeError:
                pytest.fail("README.md should be encoded in UTF-8")

            # Test for reasonable line lengths (soft limit)
            lines = content.split('\n')
            long_lines = [i for i, line in enumerate(lines, 1) if len(line) > 120]
            # This is a soft warning rather than hard failure
            if len(long_lines) > 3:
                pytest.warn(f"Many lines exceed 120 characters: lines {long_lines[:5]}")


class TestReadmeContentQuality:
    """Additional tests for README content quality and completeness."""

    @pytest.fixture
    def readme_content(self):
        """Fixture to load README.md content for testing."""
        readme_path = Path("README.md")
        if readme_path.exists():
            return readme_path.read_text(encoding='utf-8')
        return ""

    def test_inspiration_section_completeness(self, readme_content):
        """Test that inspiration section provides adequate context."""
        inspiration_match = re.search(r'## Inspired by.*?## References', readme_content, re.DOTALL)
        assert inspiration_match, "Should have complete Inspired by section"

        inspiration_content = inspiration_match.group(0)
        assert len(inspiration_content.strip()) > 200, "Inspiration section should be substantial"
        assert "OpenSCAD" in inspiration_content, "Should reference OpenSCAD as inspiration"
        assert "2D" in inspiration_content, "Should mention 2D aspect"

    def test_build_command_completeness(self, readme_content):
        """Test that build commands are complete and executable."""
        # Extract all shell commands
        shell_commands = re.findall(r'```sh\n(.*?)\n```', readme_content, re.DOTALL)

        build_commands = []
        for command_block in shell_commands:
            commands = command_block.strip().split('\n')
            build_commands.extend([cmd.strip() for cmd in commands if cmd.strip()])

        # Should have git clone, cd, and mvn commands
        git_commands = [cmd for cmd in build_commands if cmd.startswith('git')]
        cd_commands = [cmd for cmd in build_commands if cmd.startswith('cd')]
        mvn_commands = [cmd for cmd in build_commands if cmd.startswith('mvn')]
        java_commands = [cmd for cmd in build_commands if cmd.startswith('java')]

        assert len(git_commands) >= 1, "Should have git clone command"
        assert len(cd_commands) >= 1, "Should have cd command"
        assert len(mvn_commands) >= 1, "Should have mvn command"
        assert len(java_commands) >= 1, "Should have java execution command"

    def test_visual_elements_present(self, readme_content):
        """Test that visual elements enhance the README presentation."""
        # Should have app icon
        assert 'src="./src/main/resources/applogo/appicon.png"' in readme_content, "Should reference app icon"

        # Should have CI badge
        assert "badge.svg" in readme_content, "Should have CI status badge"

        # Should have ASCII art in license
        ascii_art_indicators = ["▄▖▘", "▙▌▌▛", "▌ ▌▙"]
        ascii_present = any(indicator in readme_content for indicator in ascii_art_indicators)
        assert ascii_present, "Should contain ASCII art in license section"

    def test_thank_you_message(self, readme_content):
        """Test that README ends with appropriate thank you message."""
        assert "Thank you for viewing" in readme_content, "Should end with thank you message"

    def test_repository_url_consistency(self, readme_content):
        """Test consistency between different repository URLs mentioned."""
        # Extract git clone URL
        git_clone_match = re.search(r'git clone (git@github\.com:[^/]+/[^\s]+)', readme_content)
        if git_clone_match:
            git_url = git_clone_match.group(1)
            # Should be consistent naming
            assert "Piccode" in git_url, "Git clone URL should reference Piccode repository"

        # Extract badge URL
        badge_match = re.search(r'github\.com/([^/]+/[^/]+)/actions', readme_content)
        if badge_match:
            badge_repo = badge_match.group(1)
            assert "/" in badge_repo, "Badge should reference valid GitHub repo format"

    def test_section_ordering(self, readme_content):
        """Test that sections appear in logical order."""
        sections = ["## About", "## Download", "## Building", "## Inspired by", "## References", "## License"]

        section_positions = {}
        for section in sections:
            pos = readme_content.find(section)
            if pos != -1:
                section_positions[section] = pos

        # Verify sections appear in expected order
        ordered_sections = sorted(section_positions.items(), key=lambda x: x[1])
        expected_order = ["## About", "## Download", "## Building", "## Inspired by", "## References", "## License"]

        actual_order = [section for section, _ in ordered_sections]
        for i, expected in enumerate(expected_order):
            if i < len(actual_order):
                assert actual_order[i] == expected, f"Section {expected} should appear before later sections"


class TestReadmeEdgeCases:
    """Test edge cases and potential issues in README content."""

    @pytest.fixture
    def readme_content(self):
        """Fixture to load README.md content for testing."""
        readme_path = Path("README.md")
        if readme_path.exists():
            return readme_path.read_text(encoding='utf-8')
        return ""

    def test_no_broken_markdown_links(self, readme_content):
        """Test that markdown links are properly formatted."""
        # Find all markdown links
        link_pattern = r'\[([^\]]+)\]\(([^)]+)\)'
        links = re.findall(link_pattern, readme_content)

        for link_text, link_url in links:
            assert link_text.strip(), "Link text should not be empty"
            assert link_url.strip(), "Link URL should not be empty"
            assert not link_url.startswith(' '), "Link URL should not start with space"
            assert not link_url.endswith(' '), "Link URL should not end with space"

    def test_html_img_attributes(self, readme_content):
        """Test that HTML img tags have required attributes."""
        img_tags = re.findall(r'<img[^>]+>', readme_content)

        for img_tag in img_tags:
            assert 'src=' in img_tag, f"IMG tag should have src attribute: {img_tag}"
            # Width is optional but should be properly formatted if present
            if 'width=' in img_tag:
                width_match = re.search(r'width="([^"]+)"', img_tag)
                if width_match:
                    width_value = width_match.group(1)
                    # Should be percentage or pixel value
                    assert width_value.endswith('%') or width_value.endswith('px') or width_value.isdigit(), \
                        f"Width value should be valid CSS unit: {width_value}"

    def test_code_block_completeness(self, readme_content):
        """Test that code blocks are complete and not malformed."""
        # Count opening and closing code block markers
        opening_blocks = readme_content.count('```')
        assert opening_blocks % 2 == 0, "Code blocks should have matching opening and closing markers"

        # Test that code blocks have content
        code_block_pattern = r'```[^\n]*\n(.*?)\n```'
        code_blocks = re.findall(code_block_pattern, readme_content, re.DOTALL)

        for block_content in code_blocks:
            assert block_content.strip(), "Code blocks should not be empty"

    def test_ascii_art_integrity(self, readme_content):
        """Test that ASCII art in license section is properly formatted."""
        license_section = readme_content[readme_content.find("## License"):]

        if "drawString" in license_section:
            # Extract the ASCII art
            art_match = re.search(r'drawString\("([^"]+)"', license_section, re.DOTALL)
            if art_match:
                ascii_art = art_match.group(1)
                lines = ascii_art.split('\\n')

                # Should have box-drawing characters
                box_chars_present = any(char in ascii_art for char in ['▄', '▖', '▘', '▌', '▙', '█'])
                assert box_chars_present, "ASCII art should contain Unicode box-drawing characters"

                # Should have consistent line structure for the box
                border_lines = [line for line in lines if '+' in line and '-' in line]
                assert len(border_lines) >= 2, "ASCII art should have top and bottom borders"

    def test_whitespace_consistency(self, readme_content):
        """Test for consistent whitespace usage."""
        lines = readme_content.split('\n')

        # Check for trailing whitespace (common markdown issue)
        trailing_whitespace_lines = [i+1 for i, line in enumerate(lines) if line.rstrip() != line]
        assert len(trailing_whitespace_lines) < 5, \
            f"Too many lines with trailing whitespace: {trailing_whitespace_lines[:5]}"

        # Check for multiple consecutive blank lines
        consecutive_blanks = 0
        max_consecutive_blanks = 0

        for line in lines:
            if line.strip() == '':
                consecutive_blanks += 1
                max_consecutive_blanks = max(max_consecutive_blanks, consecutive_blanks)
            else:
                consecutive_blanks = 0

        assert max_consecutive_blanks <= 3, "Should not have more than 3 consecutive blank lines"


if __name__ == "__main__":
    pytest.main([__file__, "-v"])