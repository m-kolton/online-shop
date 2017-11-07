$(function() {
	// Active menu
	switch (menu) {
	case 'Produkty':
		$('#listProducts').addClass('active');
		break;
	case 'O nas':
		$('#about').addClass('active');
		break;
	case 'Kontakt':
		$('#contact').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
	}
});