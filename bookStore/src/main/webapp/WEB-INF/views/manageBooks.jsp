<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${css}/test.css" rel="stylesheet">

<div class="container">

	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alet-dismissable">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="card">
				<div class="card-header">
					<h4>Manage Book</h4>
				</div>
				<div class="card-body">

					<sf:form class="form-horizontal" modelAttribute="book"
						action="${contextRoot}/manage/book" method="POST">

						<div class="form-group row">
							<label class="col-md-4 col-form-label">Title</label>
							<div class="col-md-8">
								<sf:input type="text" path="title" class="form-control"
									placeholder="Book's Name" />
								<sf:errors path="title" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label">Author</label>
							<div class="col-md-8">
								<sf:input type="text" path="author" class="form-control"
									id="Author" placeholder="Author's Name" />
								<sf:errors path="author" cssClass="help-block" element="em" />
							</div>

						</div>
						<div class="form-group row">
							<label class="col-md-4 col-form-label">Description</label>
							<div class="col-md-8">
								<sf:textarea class="form-control" path="description"
									id="Description" rows="3"
									placeholder="Enter your description here!"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>

						</div>

						<div class="form-group row">
							<label for="inputEmail3" class="col-md-4 col-form-label">Unit
								Price</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" class="form-control"
									id="inputEmail3" placeholder="Price of book" />
								<em class="help-block">Please enter Price of Book in INR</em>
							</div>

						</div>
						<div class="form-group row">
							<label for="quantity" class="col-md-4 col-form-label">No.
								of Books </label>
							<div class="col-md-8">
								<sf:input type="text" path="unitInStock" class="form-control"
									id="inputEmail3" placeholder="Qnty. of Books" />
								<sf:errors path="unitInStock" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group row">
							<label for="CategoryId" class="col-md-4 col-form-label">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select name="category" path="categoryId">
									<c:forEach items="${categories}" var="category">
										<option value="${category.categoryId}">${category.categoryName}</option>
									</c:forEach>
								</sf:select>

								<em class="help-block">Please select the category</em>

							</div>
						</div>
						<div class="text-right">

							<sf:hidden path="id" />
							<sf:hidden path="imageUrl" />
							<sf:hidden path="active" />

							<button type="button" class="btn btn-warning btn-sm"
								data-toggle="modal" data-target="#myCategoryModal">Add
								New Category</button>
						</div>

						<div class="form-group row">

							<div class="col-md-10" align="right">
								<input type="submit" class="btn btn-primary" id="submit"
									value="Submit">
							</div>
						</div>


					</sf:form>
				</div>



			</div>

		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">New Category</h4>
	      </div>
	      <div class="modal-body">
	        
	        <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="CategoryName" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			     	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>	        
	        </sf:form>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="col-md-12">
		<h3>Available Books</h3>
		<br>
		<hr />
	</div>

	<div class="row">


		<div class='col-xs-12'>


			<table id="productsTable"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Auther</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</thead>
				<c:forEach var="book" items="${BooksList}">
					<tr>
						<td>${book.id}</td>
						<td><img class="adminTableImg"
							src="${images}/${book.imageUrl}" alt="book" /></td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.unitInStock}</td>
						<td>&#x20b9;${book.unitPrice}</td>
						<td>
							<!-- Toggle switch for active --> <!-- Rounded switch --> <c:if
								test="${book.active == true }">
								<label class="switch"> <input type="checkbox"
									checked="checked" value="${book.id}" /> <span
									class="slider round"></span>
								</label>
							</c:if> <c:if test="${book.active == false }">
								<label class="switch"> <input type="checkbox"
									value="${book.id}" /> <span class="slider round"></span>
								</label>
							</c:if>



						</td>
						<td><a href="${contextRoot}/manage/${book.id}/book"
							class="btn btn-warning"> <span
								class="glyphicon glyphicon-pencil"></span>&#x270E;
						</a></td>
					</tr>
				</c:forEach>

				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Auther</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</tfoot>


			</table>


		</div>


	</div>



</div>
<script src="${js}/jquery.js"></script>
<script src="${js}/bootstrap.bundle.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>