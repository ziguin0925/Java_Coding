SELECT COUNT(*) 'FISH_COUNT'
    FROM FISH_INFO
    WHERE FISH_TYPE in
        (SELECT FISH_TYPE FROM FISH_NAME_INFO WHERE FISH_NAME in('BASS','SNAPPER'));