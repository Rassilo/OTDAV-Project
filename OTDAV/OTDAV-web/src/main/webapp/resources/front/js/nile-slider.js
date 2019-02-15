function setREVStartSize(e) {
	try {
		e.c = jQuery(e.c);
		var i = jQuery(window).width(),
			t = 9999,
			r = 0,
			n = 0,
			l = 0,
			f = 0,
			s = 0,
			h = 0;
		if (e.responsiveLevels && (jQuery.each(e.responsiveLevels, function (e, f) {
				f > i && (t = r = f, l = e), i > f && f > r && (r = f, n = e)
			}), t > r && (l = n)), f = e.gridheight[l] || e.gridheight[0] || e.gridheight, s = e.gridwidth[l] || e.gridwidth[0] || e.gridwidth, h = i / s, h = h > 1 ? 1 : h, f = Math.round(h * f), "fullscreen" == e.sliderLayout) {
			var u = (e.c.width(), jQuery(window).height());
			if (void 0 != e.fullScreenOffsetContainer) {
				var c = e.fullScreenOffsetContainer.split(",");
				if (c) jQuery.each(c, function (e, i) {
					u = jQuery(i).length > 0 ? u - jQuery(i).outerHeight(!0) : u
				}), e.fullScreenOffset.split("%").length > 1 && void 0 != e.fullScreenOffset && e.fullScreenOffset.length > 0 ? u -= jQuery(window).height() * parseInt(e.fullScreenOffset, 0) / 100 : void 0 != e.fullScreenOffset && e.fullScreenOffset.length > 0 && (u -= parseInt(e.fullScreenOffset, 0))
			}
			f = u
		} else void 0 != e.minHeight && f < e.minHeight && (f = e.minHeight);
		e.c.closest(".rev_slider_wrapper").css({
			height: f
		})
	} catch (d) {
		console.log("Failure at Presize of Slider:" + d)
	}
};




var revapi9,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_9_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_9_1");
		} else {
			revapi9 = tpj("#rev_slider_9_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullscreen",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					keyboardNavigation: "off",
					keyboard_direction: "horizontal",
					mouseScrollNavigation: "off",
					mouseScrollReverse: "default",
					onHoverStop: "off",
					arrows: {
						style: "zeus",
						enable: true,
						hide_onmobile: true,
						hide_under: 600,
						hide_onleave: false,
						tmp: '<div class="tp-title-wrap">  	<div class="tp-arr-imgholder"></div> </div>',
						left: {
							h_align: "left",
							v_align: "center",
							h_offset: 20,
							v_offset: 0
						},
						right: {
							h_align: "right",
							v_align: "center",
							h_offset: 20,
							v_offset: 0
						}
					},
					bullets: {
						enable: true,
						hide_onmobile: true,
						hide_under: 600,
						style: "hesperiden",
						hide_onleave: false,
						direction: "horizontal",
						h_align: "center",
						v_align: "bottom",
						h_offset: 0,
						v_offset: 100,
						space: 5,
						tmp: ''
					}
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1120, 1024, 778, 480],
				gridheight: [868, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				fullScreenAutoWidth: "off",
				fullScreenAlignForce: "off",
				fullScreenOffsetContainer: "",
				fullScreenOffset: "",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */




/* Slider (2) */

var revapi12,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_12_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_12_1");
		} else {
			revapi12 = tpj("#rev_slider_12_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [840, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* Slider (03) */

var revapi13,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_13_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_13_1");
		} else {
			revapi13 = tpj("#rev_slider_13_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1110, 1024, 778, 480],
				visibilityLevels: [1110, 1024, 778, 480],
				gridwidth: [1110, 1024, 778, 480],
				gridheight: [690, 650, 600, 700],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */




/* SLIDER 04 */


var revapi14,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_14_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_14_1");
		} else {
			revapi14 = tpj("#rev_slider_14_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [868, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 05 */

var revapi15,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_15_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_15_1");
		} else {
			revapi15 = tpj("#rev_slider_15_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1117, 1024, 778, 480],
				gridheight: [620, 620, 620, 620],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 06 */
var revapi16,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_16_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_16_1");
		} else {
			revapi16 = tpj("#rev_slider_16_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [700, 700, 650, 650],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 07 */


var revapi17,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_17_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_17_1");
		} else {
			revapi17 = tpj("#rev_slider_17_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [790, 768, 790, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */




/* SLIDER 08 */
var revapi18,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_18_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_18_1");
		} else {
			revapi18 = tpj("#rev_slider_18_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [868, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 09 */
var revapi19,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_19_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_19_1");
		} else {
			revapi19 = tpj("#rev_slider_19_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [750, 750, 750, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */

var revapi20,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_20_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_20_1");
		} else {
			revapi20 = tpj("#rev_slider_20_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [840, 768, 700, 600],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */

/* Slider 10 */

var revapi1,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_1_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_1_1");
		} else {
			revapi1 = tpj("#rev_slider_1_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [960, 768, 800, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 12 */

var revapi2,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_2_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_2_1");
		} else {
			revapi2 = tpj("#rev_slider_2_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [800, 768, 700, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */


/* Slider 13 */

var revapi3,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_3_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_3_1");
		} else {
			revapi3 = tpj("#rev_slider_3_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [720, 720, 720, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */


/* Slider 14 */

var revapi4,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_4_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_4_1");
		} else {
			revapi4 = tpj("#rev_slider_4_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1117, 1024, 778, 480],
				gridheight: [1000, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* Slider 15 */


var revapi5,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_5_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_5_1");
		} else {
			revapi5 = tpj("#rev_slider_5_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [868, 768, 960, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* Slider 16 */


var revapi6,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_6_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_6_1");
		} else {
			revapi6 = tpj("#rev_slider_6_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [930, 768, 700, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */


/* SLIDER 17 */

var revapi7,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_7_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_7_1");
		} else {
			revapi7 = tpj("#rev_slider_7_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [885, 768, 700, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* SLIDER 18 */

var revapi8,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_8_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_8_1");
		} else {
			revapi8 = tpj("#rev_slider_8_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1117, 1024, 778, 480],
				gridheight: [950, 768, 720, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* Slider 18 */

var revapi9,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_rabie_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_rabie_1");
		} else {
			revapi9 = tpj("#rev_slider_rabie_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [950, 768, 700, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */



/* Stor Slider  */

var revapi10,
	tpj;
(function () {
	if (!/loaded|interactive|complete/.test(document.readyState)) document.addEventListener("DOMContentLoaded", onLoad);
	else onLoad();

	function onLoad() {
		if (tpj === undefined) {
			tpj = jQuery;
			if ("off" == "on") tpj.noConflict();
		}
		if (tpj("#rev_slider_10_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_10_1");
		} else {
			revapi10 = tpj("#rev_slider_10_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "//localhost/slider/revslider/public/assets/js/",
				sliderLayout: "fullwidth",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					onHoverStop: "off",
				},
				responsiveLevels: [1240, 1024, 778, 480],
				visibilityLevels: [1240, 1024, 778, 480],
				gridwidth: [1240, 1024, 778, 480],
				gridheight: [920, 768, 750, 720],
				lazyType: "none",
				shadow: 0,
				spinner: "spinner0",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				disableProgressBar: "on",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}; /* END OF revapi call */
	}; /* END OF ON LOAD FUNCTION */
}()); /* END OF WRAPPING FUNCTION */
