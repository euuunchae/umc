DELETE FROM region;
INSERT INTO region (id, name, created_at, updated_at)
VALUES (1, '서울', NOW(), NOW()),
       (2, '부산', NOW(), NOW()),
       (3, '인천', NOW(), NOW());

INSERT INTO store (id, name, rating, region_id, created_at, updated_at)
VALUES (1, 'Store 1',  4.5, 1, NOW(), NOW()),
       (2, 'Store 2', 3.8, 2, NOW(), NOW()),
       (3, 'Store 3',  2.2, 3, NOW(), NOW()),
       (4, '요아정',  4.0, 1, NOW(), NOW()),
       (5, '요아정',  3.2, 2, NOW(), NOW()),
       (6, '요아정', 4.5, 3, NOW(), NOW());

INSERT INTO mission (id, content, reward, deadline, store_id, created_at, updated_at)
VALUES (1, 'Store 1-미션 1', 1, '2025-05-11',1, NOW(), NOW()),
       (2, 'Store 1-미션 2', 1, '2025-05-12', 1, NOW(), NOW()),
       (3, 'Store 2-미션 1', 1, '2025-05-13', 1,NOW(), NOW()),
       (4, 'Store 3-미션 1', 1, '2025-05-14',1, NOW(), NOW());

INSERT INTO review (id, content, rating, member_id, store_id, created_at, updated_at)
VALUES (1, '너무 좋아요!', 5.0, 1, NOW(), NOW()),
       (2, '분위기 짱~', 3.0, 1, NOW(), NOW()),
       (3, '서비스가 좋습니다', 4.8, 2, NOW(), NOW()),
       (4, '음식이 맛있고 사장님이 친절해요', 4.5, 3, NOW(), NOW());

INSERT INTO foodCategory (id, name, store_id, created_at, updated_at)
VALUES (1, '한식', 1, null, null),
       (2, '일식', 1, null, null),
       (3, '양식', 1, null, null),
       (4, '중식', 2, null, null),
       (5, '치킨', 1, null, null),
       (6, '분식', 1, null, null),
       (7, '고기/구이', 1, null, null),
       (8, '도시락',1, null, null),
       (9, '야식', 1, null, null),
       (10, '패스트푸드', 1, null, null),
       (11, '디저트', 1, null, null),
       (12, '아시안푸드', 1, null, null);
