/* This script file defines the snowflake animations */
$(window).load(function(){
    //$.keyframe.debug = true; /* Enable debugging to the console */
    
    var gaugeE = $("#gauge");
    var gUnits = $("#select-gauge-units");
    var sizeE = $("#size");
    var neededE = $("#needed").attr('readonly', 'readonly');
    var ballSizeE = $("#ball-size");
    var ballsE = $("#balls-needed").attr('readonly', 'readonly');
    var sizeUnitsE = $("#select-size-units");
    var lengthUnitsE = $("#select-length-units");
    
    var inches2cm = 2.54;
    var yards2meters = 0.9144;
    
    var smallMiss = {
        chest : 81,
        sts32 : 1500,
        sts18 : 950};
    var largeMiss = {
        chest : 101,
        sts32 : 1700,
        sts18 : 1200};

    var fcalc = function() {
        var gauge = Number(gaugeE.val());
        if (gUnits.val() == "stspinch") {
            gauge *= 4;
        }
        var size = Number(sizeE.val());
        if (sizeUnitsE.val() == "inches") {
            size *= inches2cm;
        }
        var ballSize = Number(ballSizeE.val());
        if (sizeUnitsE.val() == "yards") {
            ballSize *= yards2meters;
        }
        var gratio = (gauge - 18) / (gauge - 32);
        var smallMeters = gratio * (smallMiss.sts32 - smallMiss.sts18) + smallMiss.sts18;
        var bigMeters = gratio * (largeMiss.sts32 - largeMiss.sts18) + largeMiss.sts18;
        
        var sRatio = (size - smallMiss.chest) / (largeMiss.chest - smallMiss.chest);
        var meters = sRatio * (bigMeters - smallMeters) + smallMeters;
        
        if (lengthUnitsE.val() != "meters") {
            neededE.val(Math.ceil(meters / yards2meters));
        }
        else {
            neededE.val(Math.ceil(meters));
        }
        
        $("#balls-needed").val(Math.ceil(meters / ballSize));
    };
    
    gaugeE.change(fcalc);
    gUnits.change(fcalc);
    sizeE.change(fcalc);
    ballSizeE.change(fcalc);
    sizeUnitsE.change(fcalc);
    lengthUnitsE.change(fcalc);
    
    fcalc();
});