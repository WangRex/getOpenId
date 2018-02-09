var Page = (function() {

	var $navArrows = $('#nav-arrows').hide(), $shadow = $('#shadow').hide(), 

	init = function() {

		initEvents();

	}, initEvents = function() {
		
		var slicebox = $('#sb-slider').slicebox({
			onReady : function() {

				$navArrows.show();
				$shadow.show();

			},
			orientation : 'r',
			cuboidsRandom : true,
			autoplay:true,
			interval:3000,
			disperseFactor : 30
		})

		// add navigation events
		$navArrows.children(':first').on('click', function() {

			slicebox.next();
			return false;

		});

		$navArrows.children(':last').on('click', function() {

			slicebox.previous();
			return false;

		});

	};

	return {
		init : init
	};

})();