WITH eldest AS (
    SELECT 'OLDEST' AS type, name, birthday
    FROM worker
    WHERE birthday = (SELECT MIN(birthday) FROM worker)
),
youngest AS (
    SELECT 'YOUNGEST' AS type, name, birthday
    FROM worker
    WHERE birthday = (SELECT MAX(birthday) FROM worker)
)
SELECT * FROM eldest
UNION ALL
SELECT * FROM youngest;