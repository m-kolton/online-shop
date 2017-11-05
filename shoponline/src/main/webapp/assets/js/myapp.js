$(function() {
	// Active menu
	switch (menu) {
	case 'O nas':
		$('#about').addClass('active');
		break;
	case 'Kontakt':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
	}
});