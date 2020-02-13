CREATE TABLE ${schemaname}.AnoAnoMSCEntity (id NUMBER NOT NULL, name VARCHAR2(255), overridenNameAO VARCHAR2(255), description VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoConcreteLeaf1 (id NUMBER NOT NULL, name VARCHAR2(255), intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoConcreteLeaf2 (id NUMBER NOT NULL, name VARCHAR2(255), floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoConcreteLeaf3 (id NUMBER NOT NULL, name VARCHAR2(255), stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTCDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTCDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTCDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTCDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL CHAR(1 CHAR), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTIDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTIDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTIDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTIDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTSDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTSDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTSDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoJTSDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL VARCHAR2(31), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoSTCDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL CHAR(1 CHAR), intVal NUMBER, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoSTIDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL NUMBER, intVal NUMBER, floatVal REAL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoSTSDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL VARCHAR2(31), intVal NUMBER, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.AnoXMLMSCEntity (id NUMBER NOT NULL, name VARCHAR2(255), overridenNameAO VARCHAR2(255), description VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLAnoMSCEntity (id NUMBER NOT NULL, name VARCHAR2(255), originalNameAO VARCHAR2(255), description VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLConcreteLeaf1 (id NUMBER NOT NULL, name VARCHAR2(255), intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLConcreteLeaf2 (id NUMBER NOT NULL, name VARCHAR2(255), floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLConcreteLeaf3 (id NUMBER NOT NULL, name VARCHAR2(255), stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTCDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTCDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTCDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTCDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL CHAR(1 CHAR), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTIDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTIDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTIDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTIDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTSDLeaf1 (id NUMBER NOT NULL, intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTSDLeaf2 (id NUMBER NOT NULL, floatVal REAL, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTSDLeaf3 (id NUMBER NOT NULL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLJTSDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLSTCDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL CHAR(1 CHAR), floatVal REAL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), intVal NUMBER, PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLSTIDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL NUMBER, intVal NUMBER, floatVal REAL, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLSTSDRoot (id NUMBER NOT NULL, name VARCHAR2(255), DISC_COL VARCHAR2(255), floatVal REAL, intVal NUMBER, stringVal1 VARCHAR2(255), stringVal2 VARCHAR2(255), PRIMARY KEY (id));
CREATE TABLE ${schemaname}.XMLXMLMSCEntity (id NUMBER NOT NULL, name VARCHAR2(255), originalNameAO VARCHAR2(255), description VARCHAR2(255), PRIMARY KEY (id));
CREATE INDEX ${schemaname}.I_NJTCDRT_DTYPE ON ${schemaname}.AnoJTCDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_NJTDROT_DTYPE ON ${schemaname}.AnoJTIDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_NJTSDRT_DTYPE ON ${schemaname}.AnoJTSDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_NSTCDRT_DTYPE ON ${schemaname}.AnoSTCDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_NSTDROT_DTYPE ON ${schemaname}.AnoSTIDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_NSTSDRT_DTYPE ON ${schemaname}.AnoSTSDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLJDRT_DTYPE2 ON ${schemaname}.XMLJTCDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLJDRT_DTYPE1 ON ${schemaname}.XMLJTIDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLJDRT_DTYPE ON ${schemaname}.XMLJTSDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLSDRT_DTYPE2 ON ${schemaname}.XMLSTCDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLSDRT_DTYPE1 ON ${schemaname}.XMLSTIDRoot (DISC_COL);
CREATE INDEX ${schemaname}.I_XMLSDRT_DTYPE ON ${schemaname}.XMLSTSDRoot (DISC_COL);
  