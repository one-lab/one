Create=Create
Update=Update
Delete=Delete
Remove=Remove
View=View
Done=Done
Find=Find
Select=Select
SelectNone=Select None
Cancel=Cancel
Clear=Clear
Attributes=Attributes
Action=action
No=No
For=for
SearchCriteria=Search Criteria
PreviousPage=Previous Page
NextPage=Next Page
EnterSearchCriteria=Enter search criteria and click 'Find'
MatchedSearchCriteria=matched the search criteria
PageSize=results per page
AlreadyExists=already exists

<#foreach entity in c2j.getPOJOIterator(cfg.getClassMappings())>
${entity.shortName}=${entity.shortName}
<#foreach property in entity.getAllPropertiesIterator()>
${entity.shortName}_${property.name}=${property.name}
</#foreach>
</#foreach>