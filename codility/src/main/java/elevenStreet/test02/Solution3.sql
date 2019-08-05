SELECT
	A.team_id,
    A.team_name,
    COALESCE(num_points, 0) AS num_points
FROM
	teams AS A LEFT OUTER JOIN
	(
		SELECT
			team_id,
			SUM(num_points) AS num_points
		FROM
			(
			SELECT
				guest_team as team_id,
				CASE
				WHEN host_goals < guest_goals THEN 3
				WHEN host_goals = guest_goals THEN 1
				END AS num_points
			FROM matches
			UNION ALL
			SELECT
				host_team as team_id,
				CASE
				WHEN host_goals > guest_goals THEN 3
				WHEN host_goals = guest_goals THEN 1
				END AS num_points
			FROM matches
			)
		AS A GROUP BY team_id
	) B ON A.team_id = B.team_id
ORDER BY num_points DESC, team_id ASC