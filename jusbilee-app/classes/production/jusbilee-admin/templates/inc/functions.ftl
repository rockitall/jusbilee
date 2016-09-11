<#macro page p goto>
<#assign start=p.range.start>
<#assign end=p.range.end>
<#if end gt start >
<div class="row">
    <div class="col-md-5 col-sm-12">
        <div class="dataTables_info" id="sample_1_info" role="status" aria-live="polite">
        </div>
    </div>
    <div class="col-md-7 col-sm-12">
        <div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">
            <ul class="pagination" style="visibility: visible;">
                <#if !p.first>
                    <li class="prev"><a href="javascript:${goto}('1')" title="First"><i class="fa fa-angle-double-left"></i></a></li>
                    <li class="prev"><a href="javascript:${goto}('${p.prev}')" title="Prev"><i class="fa fa-angle-left"></i></a></li>
                <#else >
                    <li class="prev disabled"><a href="javascript:;" title="First"><i class="fa fa-angle-double-left"></i></a></li>
                    <li class="prev disabled"><a href="javascript:;" title="Prev"><i class="fa fa-angle-left"></i></a></li>
                </#if>
                <#list p.range.start..p.range.end as i>
                        <#if i==p.pageNo>
                            <li class="active"><a href="javascript:${goto}('${i}')">${i}</a></li>
                        <#else>
                            <li><a href="javascript:${goto}('${i}')">${i}</a></li>
                        </#if>
                    </#list>
                <#if !p.last>
                        <li class="next"><a href="javascript:${goto}('${p.next}')" title="Next"><i class="fa fa-angle-right"></i></a></li>
                        <li class="next"><a href="javascript:${goto}('${p.totalPage}')" title="Last"><i class="fa fa-angle-double-right"></i></a></li>
                    <#else >
                        <li class="next disabled"><a href="javascript:;" title="Next"><i class="fa fa-angle-right"></i></a></li>
                        <li class="next disabled"><a href="javascript:;" title="Last"><i class="fa fa-angle-double-right"></i></a></li>
                    </#if>
            </ul>
        </div>
    </div>
</div>
</#if>
</#macro>