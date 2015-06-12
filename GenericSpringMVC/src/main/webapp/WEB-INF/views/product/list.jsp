<c:if test="${!empty listProduct}">
	<table class="table table-bordered">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${listProduct}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.getCategory().getName()}</td>
					<td>
						<a href="<c:url value='/products/edit/${product.id}' />">Edit</a>
						|
						<a href="<c:url value='/products/remove/${product.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
