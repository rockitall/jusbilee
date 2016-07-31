<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
    <#assign len=columns?size>

    <#list columns as c>
       private ${c.javaType} ${c.columnName};<br/>
    </#list>

<br>
<br>
Insert SQL:<br>
insert into ${params.tableName} (
    <#list 0..len-1 as i>
        ${columns[i].columnName}
        <#if i<(len-1)>,</#if>
    </#list>
)values(
    <#list 0..len-1 as i>
    ?
        <#if i<(len-1)>,</#if>
    </#list>
);<br/>
update SQL:<br>
    update ${params.tableName} set
    <#list 0..len-1 as i>
    ${columns[i].columnName}
        <#if i<(len-1)>,</#if>
    </#list>
   <br/>
</body>
</html>
