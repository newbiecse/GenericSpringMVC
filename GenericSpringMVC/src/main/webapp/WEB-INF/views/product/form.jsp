<c:url var="addAction" value="/products/add"></c:url>
<form:form id="productForm" cssClass="form-horizontal" action="${addAction}"
	commandName="product">

	<c:if test="${!empty product.name}">
		<div class="form-group">
			<div class="col-md-2">
				<form:label path="id">
					<spring:message text="ID" />
				</form:label>
			</div>

			<div class="col-md-10">
				<form:input path="id" readonly="true" size="8" disabled="true" />
				<form:hidden path="id" />
			</div>
		</div>
	</c:if>
	
	<div class="form-group row">
		<div class="col-md-2">
			<form:label path="name">
				<spring:message text="Name" />
			</form:label>
		</div>
		
		<div class="col-md-10">
			<form:input cssClass="form-control" path="name" />
			<form:errors path="*" cssClass="error" element="div" />	
		</div>	
	</div>	
	
	<div class="form-group row">
		<div class="col-md-2">
			<form:label path="price">
				<spring:message text="Price" />
			</form:label>
		</div>
		
		<div class="col-md-10">
			<form:input cssClass="form-control" path="price" />
			<form:errors path="*" cssClass="error" element="div" />	
		</div>	
	</div>							

	<div class="form-group row">
		<div class="col-md-2">
			<form:label path="createDate">
				<spring:message text="Create Date" />
			</form:label>
		</div>
		
		<div class="col-md-10" ng-controller="DatepickerDemoCtrl">
              <input type="text" class="form-control" datepicker-popup="{{format}}" ng-model="dt" is-open="opened" min-date="minDate" max-date="'2015-06-22'" datepicker-options="dateOptions" date-disabled="disabled(date, mode)" ng-required="true" close-text="Close" />
              <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>
              </span>		
			<form:errors path="*" cssClass="error" element="div" />	
		</div>	
	</div>

	<div class="form-group row">
		<div class="col-md-2">
			<form:label path="category">
				<spring:message text="Category" />
			</form:label>
		</div>
		
		<div class="col-md-10">
			<form:select cssClass="form-control" path="category.id" items="${categories}"></form:select>						
			<form:errors path="*" cssClass="error" element="div" />
		</div>		
	</div>
	
	<div class="form-group row">
		<c:if test="${!empty product.name}">
			<input type="submit" value="<spring:message text="Edit Product"/>" />
		</c:if>
		<c:if test="${empty product.name}">
			<input type="submit" class="btn btn-success" value="<spring:message text="Add Product"/>" />
		</c:if>				
	</div>

</form:form>
