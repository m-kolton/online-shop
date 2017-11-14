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
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
	}

	// JQuery DataTable

	var $table = $('#productListTable');

	// Execute only if table exist
	if ($table.length) {
		// console.log('Wewnątrz tabeli!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';

		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 przedmioty', '5 przedmiotów', '10 przedmiotów',
							'Wszystkie przedmioty' ] ],
			pageLength : 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
					data: 'name',	
				},
				{
					data: 'brand',	
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return data + ' zł' 
					}
				},
				{
					data: 'quantity',	
				},
				{
					data : 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a>&#160;';
						str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';
						
						return str;
					}
				},
			]
			
		});
	}
});