INSERT INTO project (id, pid, name, budget) VALUES (1, "P1Z-5", "Server Upgrade", 100000);
INSERT INTO project (id, pid, name, budget) VALUES (2, "P91-AC", "Wiring", 50000);
INSERT INTO project (id, pid, name, budget) VALUES (3, "P8H-3", "Database Maintenance", 65400);
INSERT INTO project (id, pid, name, budget) VALUES (4, "OPS", "Operations", 750000);

INSERT INTO department (id, did, name, location) VALUES (1, "HR", "Human Resources", "Dublin");
INSERT INTO department (id, did, name, location) VALUES (2, "MAINT", "Maintenance", "Galway");
INSERT INTO department (id, did, name, location) VALUES (3, "ELECT", "Electrical", "Galway");
INSERT INTO department (id, did, name, location) VALUES (4, "SALEE", "Sales East", "Dublin");
INSERT INTO department (id, did, name, location) VALUES (5, "SALEW", "Sales West", "Galway");
INSERT INTO department (id, did, name, location) VALUES (6, "SALES", "Sales South", "Cork");

INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (1, "E001", "Thomas", 55000, 1);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (2, "E002", "Mary", 59000, 1);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (3, "E003", "John", 72401, 3);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (4, "E004", "Sean", 65432, 3);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (5, "E005", "Ann", 62003, 3);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (6, "E006", "Alan", 47333, 2);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (7, "E007", "Sara", 55323, 4);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (8, "E008", "Bill", 52353, 4);
INSERT INTO employee (id, eid, name, salary, dept_id) VALUES (9, "E009", "Rob", 57000, 5);

INSERT INTO employee_projects (employees_id, projects_id) VALUES (1, 4);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (2, 4);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (3, 2);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (3, 1);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (4, 4);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (5, 2);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (5, 4);
INSERT INTO employee_projects (employees_id, projects_id) VALUES (6, 1);


