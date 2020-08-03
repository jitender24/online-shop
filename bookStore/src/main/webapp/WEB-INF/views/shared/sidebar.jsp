
<p class="lead">Book-Store</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/categories/${category.categoryId}/books"
			class="list-group-item">${category.categoryName}</a>
	</c:forEach>
</div>


