
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">BookStore</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<div class="dropdown show">
					<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Category</a>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<c:forEach items="${categories}" var="category">
							<a class="dropdown-item"
								href="${contextRoot}/book/category/${category.categoryId}">${category.categoryName}</a>
						</c:forEach>
					</div>
				</div>

				<li class="nav-item active" id="home"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item" id="service"><a class="nav-link"
					href="${contextRoot}/Service">Services</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<li class="nav-item" id="manageBooks"><a class="nav-link"
					href="${contextRoot}/manage">Manage Books</a></li>
			</ul>
		</div>
	</div>
</nav>




