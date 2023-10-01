DO $$ 
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'customerDbUser') THEN
      CREATE USER customerDbUser WITH PASSWORD '12345' CREATEDB;
   END IF;
END $$;

DROP DATABASE IF EXISTS customer_queries;
CREATE DATABASE customer_queries;

CREATE TABLE activecontacts(id SERIAL, full_name VARCHAR(60), email VARCHAR(100), message VARCHAR(400));

CREATE TABLE archievedcontacts(id SERIAL, full_name VARCHAR(60), email VARCHAR(100), message VARCHAR(400));

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO customerDbUser;

ALTER database customer_queries OWNER TO customerDbUser;

GRANT ALL ON DATABASE customer_queries TO customerDbUser;

GRANT ALL ON TABLE activecontacts TO customerDbUser;

GRANT ALL ON TABLE archievedcontacts TO customerDbUser;


-- random commands
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Alice Johnson', 'alice@gmail.com', 'Hello, how are you?');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Bob Smith', 'bob@yahoo.com', 'Meeting at 3 PM.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Catherine Davis', 'catherine@hotmail.com', 'Reminder: Bring the documents.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('David Lee', 'david@gmail.com', 'Thanks for your help!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Emily White', 'emily@gmail.com', 'Don't forget to call.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Frank Brown', 'frank@yahoo.com', 'See you tomorrow.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Grace Taylor', 'grace@hotmail.com', 'Happy birthday!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Henry Johnson', 'henry@gmail.com', 'Check your inbox.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Isabel Smith', 'isabel@yahoo.com', 'Important update!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Jack Davis', 'jack@hotmail.com', 'Have a great day!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Katherine Lee', 'katherine@gmail.com', 'Please call me back.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Liam White', 'liam@gmail.com', 'Meeting canceled.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Mia Brown', 'mia@yahoo.com', 'Just checking in.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Noah Taylor', 'noah@hotmail.com', 'Let's catch up soon!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Olivia Johnson', 'olivia@gmail.com', 'Important notice.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Peter Smith', 'peter@yahoo.com', 'Looking forward to it!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Quinn Davis', 'quinn@hotmail.com', 'Please reply ASAP.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Ryan Lee', 'ryan@gmail.com', 'Don't worry, be happy.');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Sophia White', 'sophia@yahoo.com', 'Great news!');
INSERT INTO archievedcontacts (full_name, email, message) VALUES ('Thomas Brown', 'thomas@hotmail.com', 'Just a friendly reminder.');


