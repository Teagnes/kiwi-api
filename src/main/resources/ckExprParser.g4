grammar ckExprParser;
// select  * from table where a = 1 and b = 2 order by a desc limit 10, 20

root
    : selectStatement EOF
    ;

selectStatement
    : SELECT  selectElements fromClause? whereClause? groupByClause? orderByClause? limitClause?
    ;

selectElements
    : selectElement (',' selectElement)*
    ;

selectElement
    :  column_name (AS column_name)?
    ;

fromClause
    : FROM tableName
    ;

whereClause
    : WHERE expression
    ;

expression
    : expression (AND | OR) expression
    | column_name OPR column_value
    ;

groupByClause
    : GROUP BY column_name (',' column_name)*
    ;

orderByClause
    : ORDER BY var_order_manner+
    ;

var_order_manner
    : column_names (ASC | DESC)?
    ;


limitClause
    : LIMIT INT (',' INT)?
    ;


tableName
    : (VARIABLE)+(('.'VARIABLE)+)?
    ;

column_names
    : column_name (',' column_name)*
    ;

column_name
    : VARIABLE
    ;

column_value
    : '{'VARIABLE'}'
    | STRING
    | INT
    ;

ALL
    : '*'
    ;

AS
    : 'as'
    ;



SELECT: 'select'| 'SELECT';
DISTINCT: 'distinct'| 'DISTINCT';
FROM: 'from'| 'FROM';
WHERE: 'where'| 'WHERE';
GROUP: 'group'| 'GROUP';
BY: 'by'| 'BY';
ORDER: 'order'| 'ORDER';
ASC: 'asc'| 'ASC';
DESC: 'desc'| 'DESC';
LIMIT: 'limit'| 'LIMIT';
AND: 'and'| 'AND';
OR: 'or'| 'OR';


OPR: '=' | '<' | '>' | '<=' | '>=' | '<>' | '!=' | 'in';


// 字母下划线开头，数字或下划线数字若干结尾
VARIABLE: (CHAR+|'_')+(CHAR|INT|'_')?;
CHAR:[a-zA-Z]+;
INT:[0-9]+;

STRING:'\'' .*? '\'';
WS : [ \t\r\n]+ -> skip;






