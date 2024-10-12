SELECT client.name, COUNT(project.id) AS project_count
FROM client
JOIN project ON client.id = project.client_id
GROUP BY client.name
ORDER BY project_count DESC;