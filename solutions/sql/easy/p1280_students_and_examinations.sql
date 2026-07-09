-- LeetCode 1280: Students and Examinations
-- Problem: https://leetcode.com/problems/students-and-examinations/
--
-- Table: Students
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | student_id   | int     |
-- | student_name | varchar |
-- +--------------+---------+
--
-- Table: Subjects
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | subject_name | varchar |
-- +--------------+---------+
--
-- Table: Examinations
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | student_id   | int     |
-- | subject_name | varchar |
-- +--------------+---------+
--
-- Goal:
-- Return every student and every subject, then count how many times that
-- student attended an exam for that subject.
--
-- Concept:
-- Use a CTE to name the full list of student-subject pairs. Then use LEFT JOIN
-- so pairs with zero exams still remain in the result.

WITH all_student_subjects AS (
    SELECT
        s.student_id,
        s.student_name,
        sub.subject_name
    FROM Students s
    CROSS JOIN Subjects sub
)
SELECT
    pairs.student_id,
    pairs.student_name,
    pairs.subject_name,
    COUNT(e.subject_name) AS attended_exams
FROM all_student_subjects pairs
LEFT JOIN Examinations e
ON pairs.student_id = e.student_id
AND pairs.subject_name = e.subject_name
GROUP BY
    pairs.student_id,
    pairs.student_name,
    pairs.subject_name
ORDER BY
    pairs.student_id,
    pairs.subject_name;
