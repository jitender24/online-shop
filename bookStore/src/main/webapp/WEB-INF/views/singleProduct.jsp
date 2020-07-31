<div class="container">
<div class="img-rounded">
	<img class="img img-responsive" src="${images}/${book.imageUrl}" width="200" height="200">
</div>
<div class="Book Description">
        <hr>
       <h3>Book Name: ${book.title}</h3>
       <hr>
       <h4>Author: ${book.author}</h4>
       <p> <span> ${book.description}</span></p>
       <hr>
       <h4> Price:<strong> &#8377; ${book.unitPrice} /-</strong></h4>
       <hr>
       <h5>Qty. Available : ${book.unitInStock}</h5>
       <hr>
       <a href="#" class="btn btn-primary">Add to Cart</a>
       <a href="${contextRoot}/home" class="btn btn-warning"><span class="glyphicon glyphicon-home"></span>Continue Shopping</a>
      
       <hr>
       
       
</div>

</div>