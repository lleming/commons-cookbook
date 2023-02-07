<#list doc["composers/composer/born"] as birth>
  <p>Born: ${birth.date}, ${birth.location} ${birth?parent.name}</p>
 </#list>