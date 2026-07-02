# AGENTS.md

## Daily LeetCode Practice Rules

- Use this repository as a daily LeetCode learning log.
- When the user asks to practice today, choose a problem that is not already listed in `README.md` or present under `solutions/`.
- Prefer Easy problems unless the user asks for a harder one.
- Prefer continuing the current practice track:
  - Java algorithm problems under `solutions/java/easy/`
  - SQL problems under `solutions/sql/easy/`
  - Python only when the user explicitly asks for Python or the existing task is Python-focused
- Do not overwrite or revert existing uncommitted user changes.

## File Conventions

- Java solution files go under:
  `solutions/java/<difficulty>/P<number>_<ProblemName>.java`
- SQL solution files go under:
  `solutions/sql/<difficulty>/p<number>_<problem_slug>.sql`
- Python solution files go under:
  `solutions/python/<difficulty>/p<number>_<problem_slug>.py`
- Daily notes go under:
  `daily/YYYY-MM-DD-<topic>.md`
- Add each reviewed solution to the `README.md` reviewed solutions table.

## Daily Note Content

Each daily note should include:

- Problem number, title, link, difficulty, language, and attempt type
- The main idea in simple terms
- The final pattern or core code/query
- Time and space complexity for algorithm problems
- The SQL concept for SQL problems
- Mistakes to avoid

Use clear explanations suitable for a beginner. Prefer concrete examples over abstract wording.

## Implementation Rules

- For Java solutions, include a small `main` method with simple sample cases when practical.
- Add beginner-friendly comments to solution code, especially around the core
  algorithm, important state changes, and conditions that are easy to
  misunderstand. Explain why the code is needed instead of translating every
  line mechanically.
- Prefer beginner-readable code over compact code. For conditions that may be
  hard to read, split the logic into clearly named boolean variables or helper
  methods instead of nesting calls with negation in one line.
- In Java solutions, avoid writing dense expressions such as
  `!Character.isLetterOrDigit(s.charAt(left))` directly inside a loop condition
  when a named variable like `leftCharIsNotLetterOrDigit` would make the idea
  clearer.
- For SQL solutions, include the problem link, table shape, goal, concept, and final query.
- For Python solutions, add or update focused tests under `tests/` when promoting a reviewed solution.
- Keep edits scoped to the requested practice problem and related index/note files.

## Verification

- Compile and run Java files after editing them:
  `javac -d <temp_build_dir> solutions/java/<difficulty>/<File>.java`
  `java -cp <temp_build_dir> <ClassName>`
- Run Python tests after editing Python solutions:
  `python -m unittest discover -s tests -v`
- SQL files do not need to be executed unless a local SQL test setup exists.
- In the final response, mention what was created and what verification was run.

## Teaching Style

- If the user asks for an explanation, explain the reasoning step by step in Traditional Chinese.
- Start from the intuition, then show the code/query, then point out common mistakes.
- If the user says they do not understand, switch to a smaller example before continuing.
- When explaining code, rewrite dense expressions into smaller named steps first,
  then connect those steps back to the original code.
