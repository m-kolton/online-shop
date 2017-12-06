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
		case 'Zarządzaj':
			$('#manageProducts').addClass('active');
			break;
		default:
			if (menu == "Home")
				break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
		}

	//Tackle CSRF
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
		
	if(token.length > 0 && header.length > 0) {
		//Set token header for Ajax request
		$(document).ajaxSend(function(e, xhr, options) {
		
		xhr.setRequestHeader(header, token);	
		
		});
		
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
					mRender: function(data, type, row) {
						if(data < 1) {
							return '<span style="color:red">Brak w magazynie!</span>';
						}
					return data;	
					}
				},
				{
					data : 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a>&#160;';
						
						if(row.quantity < 1) {
							str += '<a href="javascript:void(0)" class="btn btn-success disabled" aria-disabled="true"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';
						} else {
							str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>';
						}
						
						
						return str;
					}
				},
			]
			
		});
	}
	
	//Dissmissing alert automatically
	var $alert = $('.alert');
	
	if($alert.length) {
		
		setTimeout(function() {
			
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	
	
	//Data table for Admin
	//-----------------------------------
	var $adminProductsTable = $('#adminProductsTable');

	// Execute only if table exist
	if ($adminProductsTable.length) {
		// console.log('Wewnątrz tabeli!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable.DataTable({
			lengthMenu : [
					[ 10, 20, 50, -1 ],
					[ '10 przedmiotów', '20 przedmiotów', '50 przedmiotów',
							'Wszystkie przedmioty' ] ],
			pageLength : 20,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id'
				},
				{
					data: 'code',
					bSortable: false,
					mRender: function(data, type, row) {
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
					}
				},
				{
					data: 'name',	
				},
				{
					data: 'brand',	
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if(data < 1) {
							return '<span style="color:red">Brak w magazynie!</span>';
						}
					return data;	
					}
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return data + ' zł' 
					}
				},
				{
					data: 'active',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str='';
						
						str += '<label class="switch">';
						if(data) {
							str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
						} else {
							str += '<input type="checkbox" value="'+row.id+'"/>';
						}
						
						str += '<div class="slider"></div></label>';
						
						return str;
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str = '';
						
						str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
						str += '<i class="fa fa-pencil" aria-hidden="true"></i></a>';
						
						return str;
					}
				}
				
			],
			
			initComplete: function() {
				
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function() {
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'Czy chcesz aktywować produkt?' :
										  'Czy chcesz deaktywować produkt?';
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						size: 'medium',
						title: 'Zmiana aktywności produktu',
						message: dMsg,
						
						callback: function(confirmed) {
							
							if(confirmed) {
							
							console.log(value);
							
							var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
							
							$.post(activationUrl, function(data) {
								bootbox.alert({
									title: 'Informacja',
									size: 'medium',
									message: data
								});
							});
						}
							else {
								checkbox.prop('checked', !checked);
							}
						}
					});
				});
			}
			
		});
	}
	//---------------------------------------
	
	//Validation for category
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length) {
		
		$categoryForm.validate( {
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				description: {
					required: true
				}
			},
			messages: {
				name: {
					required: 'Proszę podać nazwę kategorii!',
					minlength: 'Nazwa kategorii musi zawierać co najmniej 2 znaki!'
				},
				description: {
					required: 'Proszę podać opis kategorii!'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	//-------------------------------------------
	
	//Validation for login
	var $loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate( {
			rules: {
				username: {
					required: true,
					email: true
				},
				password: {
					required: true
				}
			},
			messages: {
				username: {
					required: 'Proszę podać nazwę użytkownika!',
					email: 'Proszę podać prawidłowy adres email!'
				},
				password: {
					required: 'Proszę podać hasło!'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
});