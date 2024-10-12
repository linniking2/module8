SELECT p.id,
    (EXTRACT(YEAR FROM age(p.finish_date, p.start_date)) * 12 + EXTRACT(MONTH FROM age(p.finish_date, p.start_date))) * SUM(w.salary) AS price
FROM project p, project_worker pw, worker w
WHERE p.id = pw.project_id AND pw.worker_id = w.id
GROUP BY p.id, p.start_date, p.finish_date
ORDER BY price DESC;
