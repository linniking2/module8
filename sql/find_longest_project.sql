SELECT id, (finish_date - start_date) / 30 AS project_duration_months
FROM project
WHERE (finish_date - start_date) / 30 = (
    SELECT MAX(finish_date - start_date) / 30
    FROM project
);