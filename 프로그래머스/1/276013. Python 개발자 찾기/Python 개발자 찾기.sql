SELECT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
    FROM DEVELOPER_INFOS as d
    WHERE SKILL_1 ='Python' or Skill_2 = 'Python' or skill_3 = 'Python'
    ORDER BY d.ID asc;