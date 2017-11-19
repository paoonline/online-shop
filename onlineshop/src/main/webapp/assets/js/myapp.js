$(function(){
	
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#ListProducts').addClass('active');
		break;
	default:
		$('#ListProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

});