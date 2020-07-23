DROP TABLE IF EXISTS parent CASCADE;

CREATE TABLE parent (
   id INT NOT NULL PRIMARY KEY,
   value VARCHAR(50) NOT NULL
);

INSERT INTO parent (id, value) VALUES
(1, 'parent_test');

DROP TABLE IF EXISTS child;

CREATE TABLE child (
    id INT NOT NULL PRIMARY KEY,
    parent_id INT NOT NULL,
    value VARCHAR(50) NOT NULL,
    FOREIGN KEY (parent_id) references parent(id)
);

INSERT INTO child (id, parent_id, value) VALUES
(1, 1, 'child_test'),
(2, 1, 'child_test2'),
(3, 1, 'child_test3'),
(4, 1, 'child_test4');