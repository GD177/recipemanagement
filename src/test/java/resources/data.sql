DROP TABLE IF EXISTS tbl_recipes;
DROP TABLE IF EXISTS tbl_categories;
DROP TABLE IF EXISTS tbl_ingredients;

CREATE TABLE tbl_recipes(
    recipe_id LONG PRIMARY KEY,
    title VARCHAR(255),
    yield INT,
    directions VARCHAR(MAX)
);

CREATE TABLE tbl_categories(
    category_id LONG PRIMARY KEY,
    category_name VARCHAR(255),
    recipe_id LONG,
    FOREIGN KEY (recipe_id) REFERENCES tbl_recipes(recipe_id)
);

CREATE TABLE tbl_ingredients(
    ingredient_id LONG PRIMARY KEY,
    quantity VARCHAR(255),
    unit VARCHAR(255),
    item VARCHAR(255),
    recipe_id LONG,
    FOREIGN KEY (recipe_id) REFERENCES tbl_recipes(recipe_id)
);

INSERT INTO tbl_recipes VALUES(1, '30 Minute Chili', 6,
'Brown the meat in a little butter and cook until the meat is brown -- about 10 minutes. Add all other ingredients and let simmer for 30 minutes. Your choice of hot sauce may be added to taste. Recipe by: MasterCook Archives Posted to recipelu-digest Volume 01 Number 577 by Rodeo46898 &lt;Rodeo46898@aol.com&gt; on Jan 22, 1998');

INSERT INTO tbl_recipes VALUES(2, 'Amaretto Cake', 1,
'Sprinkle 1 cup almonds into bottom of a well-greased       and floured 10\" tube pan; set aside. Combine cake mix,     pudding mix, eggs, oil, water, amaretto, and almond        extract in a mixing bowl; beat on low speed of an electric mixer til dry ingredients are moistened.          Increase speed to medium, and beat 4 minutes. Stir in      remaining 1/2 cup almonds. Pour batter into prepared       tube pan. Bake at 325~ for 1 hour or til a wooden pick inserted in center comes out clean. Cool cake in pan 10-15 minutes; remove from pan, and cool completely.       Combine sugar, water, and butter in a small saucepan;      bring to a boil. Reduce heat to medium and gently boil     4-5 minutes, stirring occasionally, until sugar dissolves. Remove from heat, and cool 15 minutes. Stir in amaretto and almond extract. Punch holes in top of      cake with a wooden pick; slowly spoon glaze on top of cake, allowing glaze to absorb in cake. Posted to MC-Recipe Digest V1 #263  Date: Sun, 27 Oct 1996 20:04:57 +0000 From: Cheryl Gimenez &lt;clgimenez@earthlink.net&gt;');

INSERT INTO tbl_recipes VALUES(3, 'Another Zucchini Dish', 6,
'Place zucchini and butter in a 2 quart casserole. Cover with plastic wrap. Microwave at high (100%) until tender crisp, 4 to 5 minutes. Stir in egg, pimentos and cheese. Blend well. Cover with plastic wrap. Microwave at medium (50%) until eggs are set, 10 toll minutes. Sprinkle onion rings on top. Microwave at medium (50%) until onion rings are heated, 2 to 2 1/2 minutes. Makes 6 servings. Recipe by: diane@keyway.net  Posted to recipelu-digest Volume 01 Number 217 by "Diane Geary" &lt;diane@keyway.net&gt; on Nov 7, 1997');

INSERT INTO tbl_categories VALUES(1, 'Main dish', 1);
INSERT INTO tbl_categories VALUES(2, 'Chili', 1);

INSERT INTO tbl_categories VALUES(3, 'Liquor', 2);
INSERT INTO tbl_categories VALUES(4, 'Cakes', 2);
INSERT INTO tbl_categories VALUES(5, 'Cake mixes', 2);

INSERT INTO tbl_categories VALUES(6, 'Microwave', 3);
INSERT INTO tbl_categories VALUES(7, 'Vegetables', 3);

INSERT INTO tbl_ingredients VALUES(1, '1', 'pound', 'Ground chuck or lean ground; beef', 1);
INSERT INTO tbl_ingredients VALUES(2, '1', null, 'Onion; large, chopped', 1);
INSERT INTO tbl_ingredients VALUES(3, '1', 'can', 'Kidney beans; (12 oz)', 1);
INSERT INTO tbl_ingredients VALUES(4, '1', 'can', 'Tomato soup; undiluted', 1);
INSERT INTO tbl_ingredients VALUES(5, '1', 'teaspoon', 'Salt', 1);
INSERT INTO tbl_ingredients VALUES(6, '1', 'teaspoon', 'Chili powder; (or to taste)', 1);


INSERT INTO tbl_ingredients VALUES(7, '1 1/2', 'cups', 'Toasted Almonds; chopped', 2);
INSERT INTO tbl_ingredients VALUES(8, '1', 'package', 'Yellow cake mix; no pudding', 2);
INSERT INTO tbl_ingredients VALUES(9, '1', 'package', 'Vanilla instant pudding', 2);
INSERT INTO tbl_ingredients VALUES(10, '4', null, 'Eggs', 2);
INSERT INTO tbl_ingredients VALUES(11, '1/2', 'cups', 'Vegetable oil', 2);
INSERT INTO tbl_ingredients VALUES(12, '1/2', 'cups', 'Water', 2);
INSERT INTO tbl_ingredients VALUES(13, '1/2', 'cups', 'Amaretto', 2);
INSERT INTO tbl_ingredients VALUES(14, '1', 'teaspoon', 'Almond extract', 2);
INSERT INTO tbl_ingredients VALUES(15, '1/2', 'cups', 'Sugar', 2);
INSERT INTO tbl_ingredients VALUES(16, '1/4', 'cups', 'Water', 2);
INSERT INTO tbl_ingredients VALUES(17, '2', 'tablespoons', 'Butter', 2);
INSERT INTO tbl_ingredients VALUES(18, '1/4', 'cups', 'Amaretto', 2);
INSERT INTO tbl_ingredients VALUES(19, '1/2', 'teaspoon', 'Almond extract', 2);


INSERT INTO tbl_ingredients VALUES(20, '1', 'pound', 'Zucchini; cubed 1/2 "', 3);
INSERT INTO tbl_ingredients VALUES(21, '3', 'tablespoons', 'Butter or margarine', 3);
INSERT INTO tbl_ingredients VALUES(22, '3', null, 'Eggs; beaten', 3);
INSERT INTO tbl_ingredients VALUES(23, '1', null, 'Jar pimentos; 2 1/2 oz, diced', 3);
INSERT INTO tbl_ingredients VALUES(24, '1', 'cup', 'Cheddar cheese; shredded', 3);
INSERT INTO tbl_ingredients VALUES(25, '1', 'can', 'French fried onion rings 3 oz)', 3);