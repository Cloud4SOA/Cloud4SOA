(function(){
var $gwt_version = "2.1.1";
var $wnd = window;
var $doc = $wnd.document;
var $moduleName, $moduleBase;
var $strongName = 'EA708E76F715E5A2D8824C2008680650';
var $stats = $wnd.__gwtStatsEvent ? function(a) {return $wnd.__gwtStatsEvent(a);} : null;
var $sessionId = $wnd.__gwtStatsSessionId ? $wnd.__gwtStatsSessionId : null;
$stats && $stats({moduleName:'deploymentgadget',sessionId:$sessionId,subSystem:'startup',evtGroup:'moduleStartup',millis:(new Date()).getTime(),type:'moduleEvalStart'});
var $intern_0 = '', $intern_129 = ' ', $intern_126 = ' application', $intern_125 = ' as ', $intern_124 = ' in provider ', $intern_1 = '(', $intern_132 = ', Size: ', $intern_50 = '.call(this) }', $intern_53 = '.call(this)}', $intern_7 = '/>', $intern_97 = '0', $intern_113 = '106px', $intern_110 = '135px', $intern_108 = '300px', $intern_106 = '400px', $intern_111 = '403px', $intern_112 = '71px', $intern_4 = ':', $intern_6 = '<', $intern_74 = "<BUTTON type='button'><\/BUTTON>", $intern_103 = "<INPUT type='RADIO' name='Tech'>", $intern_101 = '<SELECT>', $intern_130 = 'Add not supported on this collection', $intern_133 = 'Add not supported on this list', $intern_114 = 'Application Technology', $intern_10 = 'Cannot add a handler with a null type', $intern_11 = 'Cannot add a null handler', $intern_12 = 'Cannot fire null event', $intern_70 = 'Cannot set a new parent without first clearing the old parent', $intern_84 = 'Composite.initWidget() may only be called once.', $intern_18 = 'DEFAULT', $intern_42 = 'DOMMouseScroll', $intern_122 = 'Deploy', $intern_85 = 'INPUT', $intern_131 = 'Index: ', $intern_115 = 'Java', $intern_17 = 'LTR', $intern_77 = 'New button', $intern_116 = 'PHP', $intern_119 = 'PaaS Provider 1', $intern_120 = 'PaaS Provider 2', $intern_121 = 'PaaS Provider 3', $intern_123 = 'Please, confirm you wish to deploy file ', $intern_109 = 'Please, select your deployment file', $intern_118 = 'Please, select your provider target', $intern_117 = 'Python', $intern_16 = 'RTL', $intern_67 = "Should only call onAttach when the widget is detached from the browser's document", $intern_68 = "Should only call onDetach when the widget is attached to the browser's document", $intern_69 = "This widget's parent does not implement HasWidgets", $intern_128 = '\\', $intern_46 = '_', $intern_51 = '__gwt_dispatchDblClickEvent_', $intern_47 = '__gwt_dispatchEvent_', $intern_54 = '__gwt_dispatchUnhandledEvent_', $intern_94 = 'align', $intern_3 = 'anonymous', $intern_25 = 'blur', $intern_91 = 'bottom', $intern_98 = 'cellPadding', $intern_96 = 'cellSpacing', $intern_88 = 'center', $intern_26 = 'change', $intern_75 = 'className', $intern_9 = 'click', $intern_43 = 'contextmenu', $intern_27 = 'dblclick', $intern_127 = 'deployed-application', $intern_13 = 'dir', $intern_5 = 'div', $intern_40 = 'error', $intern_22 = 'eu.cloud4soa.ui.samples.google.gadgets.client.DeploymentGadget', $intern_86 = 'file', $intern_28 = 'focus', $intern_2 = 'function', $intern_24 = 'function __gwt_initWindowCloseHandler(beforeunload, unload) {\n  var wnd = window\n  , oldOnBeforeUnload = wnd.onbeforeunload\n  , oldOnUnload = wnd.onunload;\n  \n  wnd.onbeforeunload = function(evt) {\n    var ret, oldRet;\n    try {\n      ret = beforeunload();\n    } finally {\n      oldRet = oldOnBeforeUnload && oldOnBeforeUnload(evt);\n    }\n    // Avoid returning null as IE6 will coerce it into a string.\n    // Ensure that "" gets returned properly.\n    if (ret != null) {\n      return ret;\n    }\n    if (oldRet != null) {\n      return oldRet;\n    }\n    // returns undefined.\n  };\n  \n  wnd.onunload = function(evt) {\n    try {\n      unload();\n    } finally {\n      oldOnUnload && oldOnUnload(evt);\n      wnd.onresize = null;\n      wnd.onscroll = null;\n      wnd.onbeforeunload = null;\n      wnd.onunload = null;\n    }\n  };\n  \n  // Remove the reference once we\'ve initialize the handler\n  wnd.__gwt_initWindowCloseHandler = undefined;\n}\n', $intern_76 = 'gwt-Button', $intern_87 = 'gwt-FileUpload', $intern_99 = 'gwt-Label', $intern_102 = 'gwt-ListBox', $intern_104 = 'gwt-RadioButton', $intern_8 = 'gwt-uid-', $intern_107 = 'height', $intern_83 = 'id', $intern_89 = 'justify', $intern_29 = 'keydown', $intern_30 = 'keypress', $intern_31 = 'keyup', $intern_82 = 'label', $intern_71 = 'left', $intern_32 = 'load', $intern_33 = 'losecapture', $intern_15 = 'ltr', $intern_92 = 'middle', $intern_20 = 'moduleStartup', $intern_34 = 'mousedown', $intern_35 = 'mousemove', $intern_36 = 'mouseout', $intern_37 = 'mouseover', $intern_38 = 'mouseup', $intern_41 = 'mousewheel', $intern_21 = 'onModuleLoadStart', $intern_64 = 'onblur', $intern_45 = 'onclick', $intern_66 = 'oncontextmenu', $intern_65 = 'ondblclick', $intern_63 = 'onfocus', $intern_60 = 'onkeydown', $intern_61 = 'onkeypress', $intern_62 = 'onkeyup', $intern_56 = 'onmousedown', $intern_58 = 'onmousemove', $intern_57 = 'onmouseup', $intern_59 = 'onmousewheel', $intern_100 = 'option', $intern_44 = 'paste', $intern_73 = 'position', $intern_52 = 'return function() { w.__gwt_dispatchDblClickEvent_', $intern_49 = 'return function() { w.__gwt_dispatchEvent_', $intern_55 = 'return function() { w.__gwt_dispatchUnhandledEvent_', $intern_90 = 'right', $intern_14 = 'rtl', $intern_23 = 'script', $intern_39 = 'scroll', $intern_81 = 'span', $intern_19 = 'startup', $intern_79 = 'table', $intern_80 = 'tbody', $intern_93 = 'td', $intern_72 = 'top', $intern_95 = 'tr', $intern_78 = 'verticalAlign', $intern_48 = 'w', $intern_105 = 'width';
var _;
function nullMethod(){
}

function java_lang_Object(){
}

_ = java_lang_Object.prototype = {};
_.equals__Ljava_lang_Object_2Z$ = function java_lang_Object_equals__Ljava_lang_Object_2Z(other){
  return this === other;
}
;
_.hashCode__I$ = function java_lang_Object_hashCode__I(){
  return this.$H || (this.$H = ++com_google_gwt_core_client_impl_Impl_sNextHashId);
}
;
_.java_lang_Object_typeMarker$ = nullMethod;
_.java_lang_Object_castableTypeMap$ = {};
function java_lang_Throwable_$setStackTrace__Ljava_lang_Throwable_2_3Ljava_lang_StackTraceElement_2V(stackTrace){
  var c, copy, i;
  copy = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1StackTraceElement_12_1classLit, {23:1}, 26, stackTrace.length, 0);
  for (i = 0 , c = stackTrace.length; i < c; ++i) {
    if (!stackTrace[i]) {
      throw new java_lang_NullPointerException_NullPointerException__V;
    }
    copy[i] = stackTrace[i];
  }
}

function java_lang_Throwable(){
}

_ = java_lang_Throwable.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {7:1, 23:1};
function java_lang_Exception(){
}

_ = java_lang_Exception.prototype = new java_lang_Throwable;
_.java_lang_Object_castableTypeMap$ = {7:1, 23:1};
function java_lang_RuntimeException_RuntimeException__Ljava_lang_String_2Ljava_lang_Throwable_2V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_RuntimeException(){
}

_ = java_lang_RuntimeException.prototype = new java_lang_Exception;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V(e){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
  this.com_google_gwt_core_client_JavaScriptException_e = e;
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$createStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Lcom_google_gwt_core_client_JavaScriptException_2V(this);
}

function com_google_gwt_core_client_JavaScriptException(){
}

_ = com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V.prototype = com_google_gwt_core_client_JavaScriptException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
_.com_google_gwt_core_client_JavaScriptException_e = null;
function com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(this$static, other){
  return this$static.java_lang_Object_typeMarker$ == nullMethod || this$static.java_lang_Object_castableTypeMap$ && !!this$static.java_lang_Object_castableTypeMap$[1]?this$static.equals__Ljava_lang_Object_2Z$(other):this$static === other;
}

function com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(this$static){
  return this$static.java_lang_Object_typeMarker$ == nullMethod || this$static.java_lang_Object_castableTypeMap$ && !!this$static.java_lang_Object_castableTypeMap$[1]?this$static.hashCode__I$():this$static.$H || (this$static.$H = ++com_google_gwt_core_client_impl_Impl_sNextHashId);
}

function com_google_gwt_core_client_Scheduler(){
}

_ = com_google_gwt_core_client_Scheduler.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_core_client_impl_Impl_enter__Z(){
  if (com_google_gwt_core_client_impl_Impl_entryDepth++ == 0) {
    com_google_gwt_core_client_impl_SchedulerImpl_$flushEntryCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V((com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V() , com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE));
    return true;
  }
  return false;
}

function com_google_gwt_core_client_impl_Impl_entry__Lcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(jsFunction){
  return function(){
    try {
      return com_google_gwt_core_client_impl_Impl_entry0__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, this, arguments);
    }
     catch (e) {
      throw e;
    }
  }
  ;
}

function com_google_gwt_core_client_impl_Impl_entry0__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, thisObj, arguments){
  var initialEntry;
  initialEntry = com_google_gwt_core_client_impl_Impl_enter__Z();
  try {
    return jsFunction.apply(thisObj, arguments);
  }
   finally {
    initialEntry && com_google_gwt_core_client_impl_SchedulerImpl_$flushFinallyCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V((com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V() , com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE));
    --com_google_gwt_core_client_impl_Impl_entryDepth;
  }
}

var com_google_gwt_core_client_impl_Impl_entryDepth = 0, com_google_gwt_core_client_impl_Impl_sNextHashId = 0;
function com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V(){
  com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V = nullMethod;
  com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE = new com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V;
}

function com_google_gwt_core_client_impl_SchedulerImpl_$flushEntryCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V(this$static){
  var oldQueue, rescheduled;
  if (this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands) {
    rescheduled = null;
    do {
      oldQueue = this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands;
      this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = null;
      rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(oldQueue, rescheduled);
    }
     while (this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands);
    this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = rescheduled;
  }
}

function com_google_gwt_core_client_impl_SchedulerImpl_$flushFinallyCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V(this$static){
  var oldQueue, rescheduled;
  if (this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands) {
    rescheduled = null;
    do {
      oldQueue = this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands;
      this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = null;
      rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(oldQueue, rescheduled);
    }
     while (this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands);
    this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = rescheduled;
  }
}

function com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V(){
}

function com_google_gwt_core_client_impl_SchedulerImpl_push__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_impl_SchedulerImpl$Task_2Lcom_google_gwt_core_client_JsArray_2(queue, task){
  !queue && (queue = []);
  queue[queue.length] = task;
  return queue;
}

function com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(tasks, rescheduled){
  var $e0, i, j, t;
  for (i = 0 , j = tasks.length; i < j; ++i) {
    t = tasks[i];
    try {
      t[1]?t[0].nullMethod() && (rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_push__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_impl_SchedulerImpl$Task_2Lcom_google_gwt_core_client_JsArray_2(rescheduled, t)):(com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V(t[0].com_google_gwt_event_shared_SimpleEventBus$2_this$0, t[0].com_google_gwt_event_shared_SimpleEventBus$2_val$type, t[0].com_google_gwt_event_shared_SimpleEventBus$2_val$handler) , undefined);
    }
     catch ($e0) {
      $e0 = com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2($e0);
      if (!com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ($e0, 2))
        throw $e0;
    }
  }
  return rescheduled;
}

function com_google_gwt_core_client_impl_SchedulerImpl(){
}

_ = com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V.prototype = com_google_gwt_core_client_impl_SchedulerImpl.prototype = new com_google_gwt_core_client_Scheduler;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = null;
_.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = null;
var com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE;
function com_google_gwt_core_client_impl_StackTraceCreator_extractNameFromToString__Ljava_lang_String_2Ljava_lang_String_2(fnToString){
  var index, start, toReturn;
  toReturn = $intern_0;
  fnToString = java_lang_String_$trim__Ljava_lang_String_2Ljava_lang_String_2(fnToString);
  index = fnToString.indexOf($intern_1);
  if (index != -1) {
    start = fnToString.indexOf($intern_2) == 0?8:0;
    toReturn = java_lang_String_$trim__Ljava_lang_String_2Ljava_lang_String_2(fnToString.substr(start, index - start));
  }
  return toReturn.length > 0?toReturn:$intern_3;
}

function com_google_gwt_core_client_impl_StackTraceCreator$Collector_$collect__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Lcom_google_gwt_core_client_JsArrayString_2(this$static){
  var seen = {};
  var toReturn = [];
  var callee = arguments.callee.caller.caller;
  while (callee) {
    var name = this$static.extractName__Ljava_lang_String_2Ljava_lang_String_2(callee.toString());
    toReturn.push(name);
    var keyName = $intern_4 + name;
    var withThisName = seen[keyName];
    if (withThisName) {
      var i, j;
      for (i = 0 , j = withThisName.length; i < j; i++) {
        if (withThisName[i] === callee) {
          return toReturn;
        }
      }
    }
    (withThisName || (seen[keyName] = [])).push(callee);
    callee = callee.caller;
  }
  return toReturn;
}

function com_google_gwt_core_client_impl_StackTraceCreator$Collector_$createStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Lcom_google_gwt_core_client_JavaScriptException_2V(e){
  var i, j, stack, stackTrace;
  stack = (com_google_gwt_lang_Cast_instanceOfJso__Ljava_lang_Object_2Z(e.com_google_gwt_core_client_JavaScriptException_e)?com_google_gwt_lang_Cast_dynamicCastJso__Ljava_lang_Object_2Ljava_lang_Object_2(e.com_google_gwt_core_client_JavaScriptException_e):null , []);
  stackTrace = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1StackTraceElement_12_1classLit, {23:1}, 26, stack.length, 0);
  for (i = 0 , j = stackTrace.length; i < j; ++i) {
    stackTrace[i] = new java_lang_StackTraceElement_StackTraceElement__Ljava_lang_String_2Ljava_lang_String_2Ljava_lang_String_2IV(stack[i]);
  }
  java_lang_Throwable_$setStackTrace__Ljava_lang_Throwable_2_3Ljava_lang_StackTraceElement_2V(stackTrace);
}

function com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V(){
  var i, j, stack, stackTrace;
  stack = com_google_gwt_core_client_impl_StackTraceCreator$Collector_$collect__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Lcom_google_gwt_core_client_JsArrayString_2(new com_google_gwt_core_client_impl_StackTraceCreator$Collector_StackTraceCreator$Collector__V);
  stackTrace = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1StackTraceElement_12_1classLit, {23:1}, 26, stack.length, 0);
  for (i = 0 , j = stackTrace.length; i < j; ++i) {
    stackTrace[i] = new java_lang_StackTraceElement_StackTraceElement__Ljava_lang_String_2Ljava_lang_String_2Ljava_lang_String_2IV(stack[i]);
  }
  java_lang_Throwable_$setStackTrace__Ljava_lang_Throwable_2_3Ljava_lang_StackTraceElement_2V(stackTrace);
}

function com_google_gwt_core_client_impl_StackTraceCreator$Collector_StackTraceCreator$Collector__V(){
}

function com_google_gwt_core_client_impl_StackTraceCreator$Collector(){
}

_ = com_google_gwt_core_client_impl_StackTraceCreator$Collector_StackTraceCreator$Collector__V.prototype = com_google_gwt_core_client_impl_StackTraceCreator$Collector.prototype = new java_lang_Object;
_.extractName__Ljava_lang_String_2Ljava_lang_String_2 = function com_google_gwt_core_client_impl_StackTraceCreator$Collector_extractName__Ljava_lang_String_2Ljava_lang_String_2(fnToString){
  return com_google_gwt_core_client_impl_StackTraceCreator_extractNameFromToString__Ljava_lang_String_2Ljava_lang_String_2(fnToString);
}
;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_dom_client_DOMImpl_$getFirstChildElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_dom_client_Element_2(elem){
  var child = elem.firstChild;
  while (child && child.nodeType != 1)
    child = child.nextSibling;
  return child;
}

function com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2(node){
  var parent = node.parentNode;
  (!parent || parent.nodeType != 1) && (parent = null);
  return parent;
}

function com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2(doc, tagName){
  var container, elem;
  if (tagName.indexOf($intern_4) != -1) {
    container = (!doc.__gwt_container && (doc.__gwt_container = doc.createElement($intern_5)) , doc.__gwt_container);
    container.innerHTML = $intern_6 + tagName + $intern_7 || $intern_0;
    elem = com_google_gwt_dom_client_DOMImpl_$getFirstChildElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_dom_client_Element_2(container);
    container.removeChild(elem);
    return elem;
  }
  return doc.createElement(tagName);
}

function com_google_gwt_dom_client_DOMImplTrident_$isOrHasChild__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Node_2Z(parent, child){
  if (parent.nodeType != 1 && parent.nodeType != 9) {
    return parent == child;
  }
  if (child.nodeType != 1) {
    child = child.parentNode;
    if (!child) {
      return false;
    }
  }
  return parent === child || parent.contains(child);
}

var com_google_gwt_dom_client_DOMImplTrident_currentEventTarget = null;
function com_google_gwt_dom_client_Document_$createUniqueId__Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2(this$static){
  !this$static.gwt_uid && (this$static.gwt_uid = 1);
  return $intern_8 + this$static.gwt_uid++;
}

function com_google_gwt_dom_client_Element_is__Lcom_google_gwt_core_client_JavaScriptObject_2Z(o){
  if (!!o && !!o.nodeType) {
    return !!o && o.nodeType == 1;
  }
  return false;
}

function com_google_gwt_event_shared_GwtEvent(){
}

_ = com_google_gwt_event_shared_GwtEvent.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_event_shared_GwtEvent_dead = false;
_.com_google_gwt_event_shared_GwtEvent_source = null;
function com_google_gwt_event_dom_client_DomEvent_fireNativeEvent__Lcom_google_gwt_dom_client_NativeEvent_2Lcom_google_gwt_event_shared_HasHandlers_2Lcom_google_gwt_dom_client_Element_2V(nativeEvent, handlerSource, relativeElem){
  var currentNative, currentRelativeElem, typeKey;
  if (com_google_gwt_event_dom_client_DomEvent_registered) {
    typeKey = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(com_google_gwt_event_dom_client_DomEvent_registered.com_google_gwt_event_dom_client_PrivateMap_map[nativeEvent.type], 4);
    if (typeKey) {
      currentNative = typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_nativeEvent;
      currentRelativeElem = typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_relativeElem;
      typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_nativeEvent = nativeEvent;
      typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_relativeElem = relativeElem;
      com_google_gwt_user_client_ui_Widget_$fireEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_event_shared_GwtEvent_2V(handlerSource, typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight);
      typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_nativeEvent = currentNative;
      typeKey.com_google_gwt_event_dom_client_DomEvent$Type_flyweight.com_google_gwt_event_dom_client_DomEvent_relativeElem = currentRelativeElem;
    }
  }
}

function com_google_gwt_event_dom_client_DomEvent(){
}

_ = com_google_gwt_event_dom_client_DomEvent.prototype = new com_google_gwt_event_shared_GwtEvent;
_.getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2 = function com_google_gwt_event_dom_client_DomEvent_getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2(){
  return com_google_gwt_event_dom_client_ClickEvent_$clinit__V() , com_google_gwt_event_dom_client_ClickEvent_TYPE;
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_event_dom_client_DomEvent_nativeEvent = null;
_.com_google_gwt_event_dom_client_DomEvent_relativeElem = null;
var com_google_gwt_event_dom_client_DomEvent_registered = null;
function com_google_gwt_event_dom_client_MouseEvent(){
}

_ = com_google_gwt_event_dom_client_MouseEvent.prototype = new com_google_gwt_event_dom_client_DomEvent;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_event_dom_client_ClickEvent_$clinit__V(){
  com_google_gwt_event_dom_client_ClickEvent_$clinit__V = nullMethod;
  com_google_gwt_event_dom_client_ClickEvent_TYPE = new com_google_gwt_event_dom_client_DomEvent$Type_DomEvent$Type__Ljava_lang_String_2Lcom_google_gwt_event_dom_client_DomEvent_2V(new com_google_gwt_event_dom_client_ClickEvent_ClickEvent__V);
}

function com_google_gwt_event_dom_client_ClickEvent_ClickEvent__V(){
}

function com_google_gwt_event_dom_client_ClickEvent(){
}

_ = com_google_gwt_event_dom_client_ClickEvent_ClickEvent__V.prototype = com_google_gwt_event_dom_client_ClickEvent.prototype = new com_google_gwt_event_dom_client_MouseEvent;
_.dispatch__Lcom_google_gwt_event_shared_EventHandler_2V = function com_google_gwt_event_dom_client_ClickEvent_dispatch__Lcom_google_gwt_event_shared_EventHandler_2V(handler){
  eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_$onClick__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_2Lcom_google_gwt_event_dom_client_ClickEvent_2V(com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(handler, 3));
}
;
_.java_lang_Object_castableTypeMap$ = {};
var com_google_gwt_event_dom_client_ClickEvent_TYPE;
function com_google_gwt_event_shared_GwtEvent$Type_GwtEvent$Type__V(){
  this.com_google_gwt_event_shared_GwtEvent$Type_index = ++com_google_gwt_event_shared_GwtEvent$Type_nextHashCode;
}

function com_google_gwt_event_shared_GwtEvent$Type(){
}

_ = com_google_gwt_event_shared_GwtEvent$Type_GwtEvent$Type__V.prototype = com_google_gwt_event_shared_GwtEvent$Type.prototype = new java_lang_Object;
_.hashCode__I$ = function com_google_gwt_event_shared_GwtEvent$Type_hashCode__I(){
  return this.com_google_gwt_event_shared_GwtEvent$Type_index;
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_event_shared_GwtEvent$Type_index = 0;
var com_google_gwt_event_shared_GwtEvent$Type_nextHashCode = 0;
function com_google_gwt_event_dom_client_DomEvent$Type_DomEvent$Type__Ljava_lang_String_2Lcom_google_gwt_event_dom_client_DomEvent_2V(flyweight){
  this.com_google_gwt_event_shared_GwtEvent$Type_index = ++com_google_gwt_event_shared_GwtEvent$Type_nextHashCode;
  this.com_google_gwt_event_dom_client_DomEvent$Type_flyweight = flyweight;
  !com_google_gwt_event_dom_client_DomEvent_registered && (com_google_gwt_event_dom_client_DomEvent_registered = new com_google_gwt_event_dom_client_PrivateMap_PrivateMap__V);
  com_google_gwt_event_dom_client_DomEvent_registered.com_google_gwt_event_dom_client_PrivateMap_map[$intern_9] = this;
  this.com_google_gwt_event_dom_client_DomEvent$Type_name = $intern_9;
}

function com_google_gwt_event_dom_client_DomEvent$Type(){
}

_ = com_google_gwt_event_dom_client_DomEvent$Type_DomEvent$Type__Ljava_lang_String_2Lcom_google_gwt_event_dom_client_DomEvent_2V.prototype = com_google_gwt_event_dom_client_DomEvent$Type.prototype = new com_google_gwt_event_shared_GwtEvent$Type;
_.java_lang_Object_castableTypeMap$ = {4:1};
_.com_google_gwt_event_dom_client_DomEvent$Type_flyweight = null;
_.com_google_gwt_event_dom_client_DomEvent$Type_name = null;
function com_google_gwt_event_dom_client_PrivateMap_PrivateMap__V(){
  this.com_google_gwt_event_dom_client_PrivateMap_map = {};
}

function com_google_gwt_event_dom_client_PrivateMap(){
}

_ = com_google_gwt_event_dom_client_PrivateMap_PrivateMap__V.prototype = com_google_gwt_event_dom_client_PrivateMap.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_event_dom_client_PrivateMap_map = null;
function com_google_gwt_event_logical_shared_CloseEvent_CloseEvent__Ljava_lang_Object_2ZV(){
}

function com_google_gwt_event_logical_shared_CloseEvent_fire__Lcom_google_gwt_event_logical_shared_HasCloseHandlers_2Ljava_lang_Object_2ZV(source){
  var event;
  if (com_google_gwt_event_logical_shared_CloseEvent_TYPE) {
    event = new com_google_gwt_event_logical_shared_CloseEvent_CloseEvent__Ljava_lang_Object_2ZV;
    com_google_gwt_event_shared_HandlerManager_$fireEvent__Lcom_google_gwt_event_shared_HandlerManager_2Lcom_google_gwt_event_shared_GwtEvent_2V(source, event);
  }
}

function com_google_gwt_event_logical_shared_CloseEvent(){
}

_ = com_google_gwt_event_logical_shared_CloseEvent_CloseEvent__Ljava_lang_Object_2ZV.prototype = com_google_gwt_event_logical_shared_CloseEvent.prototype = new com_google_gwt_event_shared_GwtEvent;
_.dispatch__Lcom_google_gwt_event_shared_EventHandler_2V = function com_google_gwt_event_logical_shared_CloseEvent_dispatch__Lcom_google_gwt_event_shared_EventHandler_2V(handler){
  com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(handler, 5);
  com_google_gwt_user_client_ui_RootPanel_detachWidgets__V();
}
;
_.getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2 = function com_google_gwt_event_logical_shared_CloseEvent_getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2(){
  return com_google_gwt_event_logical_shared_CloseEvent_TYPE;
}
;
_.java_lang_Object_castableTypeMap$ = {};
var com_google_gwt_event_logical_shared_CloseEvent_TYPE = null;
function com_google_gwt_event_logical_shared_ValueChangeEvent_fireIfNotEqual__Lcom_google_gwt_event_logical_shared_HasValueChangeHandlers_2Ljava_lang_Object_2Ljava_lang_Object_2V(){
}

function com_google_gwt_event_shared_EventBus(){
}

_ = com_google_gwt_event_shared_EventBus.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {18:1};
function com_google_gwt_event_shared_HandlerManager_$fireEvent__Lcom_google_gwt_event_shared_HandlerManager_2Lcom_google_gwt_event_shared_GwtEvent_2V(this$static, event){
  var oldSource;
  !event.com_google_gwt_event_shared_GwtEvent_dead || (event.com_google_gwt_event_shared_GwtEvent_dead = false , event.com_google_gwt_event_shared_GwtEvent_source = null);
  oldSource = event.com_google_gwt_event_shared_GwtEvent_source;
  event.com_google_gwt_event_shared_GwtEvent_source = this$static.com_google_gwt_event_shared_HandlerManager_source;
  try {
    com_google_gwt_event_shared_SimpleEventBus_$fireEvent__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent_2V(this$static.com_google_gwt_event_shared_HandlerManager_eventBus, event);
  }
   finally {
    oldSource == null?(event.com_google_gwt_event_shared_GwtEvent_dead = true , event.com_google_gwt_event_shared_GwtEvent_source = null):(event.com_google_gwt_event_shared_GwtEvent_source = oldSource);
  }
}

function com_google_gwt_event_shared_HandlerManager_HandlerManager__Ljava_lang_Object_2V(source){
  this.com_google_gwt_event_shared_HandlerManager_eventBus = new com_google_gwt_event_shared_SimpleEventBus_SimpleEventBus__ZV;
  this.com_google_gwt_event_shared_HandlerManager_source = source;
}

function com_google_gwt_event_shared_HandlerManager(){
}

_ = com_google_gwt_event_shared_HandlerManager_HandlerManager__Ljava_lang_Object_2V.prototype = com_google_gwt_event_shared_HandlerManager.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {18:1};
_.com_google_gwt_event_shared_HandlerManager_eventBus = null;
_.com_google_gwt_event_shared_HandlerManager_source = null;
function com_google_gwt_event_shared_SimpleEventBus_$addHandler__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2(this$static, type, handler){
  var com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V_l_0;
  if (!type) {
    throw new java_lang_NullPointerException_NullPointerException__Ljava_lang_String_2V($intern_10);
  }
  if (!handler) {
    throw new java_lang_NullPointerException_NullPointerException__Ljava_lang_String_2V($intern_11);
  }
  return this$static.com_google_gwt_event_shared_SimpleEventBus_firingDepth > 0?com_google_gwt_event_shared_SimpleEventBus_$defer__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_core_client_Scheduler$ScheduledCommand_2V(this$static, new com_google_gwt_event_shared_SimpleEventBus$2_SimpleEventBus$2__Lcom_google_gwt_event_shared_SimpleEventBus_2V(this$static, type, handler)):(com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V_l_0 = com_google_gwt_event_shared_SimpleEventBus_$ensureHandlerList__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Ljava_util_List_2(this$static, type) , com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V_l_0.add__Ljava_lang_Object_2Z(handler) , undefined) , new com_google_gwt_event_shared_SimpleEventBus$1_SimpleEventBus$1__Lcom_google_gwt_event_shared_SimpleEventBus_2V;
}

function com_google_gwt_event_shared_SimpleEventBus_$defer__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_core_client_Scheduler$ScheduledCommand_2V(this$static, command){
  !this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas && (this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas = new java_util_ArrayList_ArrayList__V);
  java_util_ArrayList_$add__Ljava_util_ArrayList_2Ljava_lang_Object_2Z(this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas, command);
}

function com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V(this$static, type, handler){
  var l;
  l = com_google_gwt_event_shared_SimpleEventBus_$ensureHandlerList__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Ljava_util_List_2(this$static, type);
  l.add__Ljava_lang_Object_2Z(handler);
}

function com_google_gwt_event_shared_SimpleEventBus_$doFire__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent_2Ljava_lang_Object_2V(this$static, event){
  var $e0, causes, e, handler, handlers, it, java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0;
  try {
    ++this$static.com_google_gwt_event_shared_SimpleEventBus_firingDepth;
    handlers = com_google_gwt_event_shared_SimpleEventBus_$getHandlerList__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Ljava_util_List_2(this$static, event.getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2());
    causes = null;
    it = this$static.com_google_gwt_event_shared_SimpleEventBus_isReverseOrder?handlers.listIterator__ILjava_util_ListIterator_2(handlers.size__I()):handlers.listIterator__Ljava_util_ListIterator_2();
    while (this$static.com_google_gwt_event_shared_SimpleEventBus_isReverseOrder?it.java_util_AbstractList$IteratorImpl_i > 0:it.java_util_AbstractList$IteratorImpl_i < it.java_util_AbstractList$IteratorImpl_this$0.size__I()) {
      handler = this$static.com_google_gwt_event_shared_SimpleEventBus_isReverseOrder?com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$ListIteratorImpl_$previous__Ljava_util_AbstractList$ListIteratorImpl_2Ljava_lang_Object_2(it), 6):com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(it), 6);
      try {
        event.dispatch__Lcom_google_gwt_event_shared_EventHandler_2V(handler);
      }
       catch ($e0) {
        $e0 = com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2($e0);
        if (com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ($e0, 7)) {
          e = $e0;
          !causes && (causes = new java_util_HashSet_HashSet__V);
          java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0 = java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(causes.java_util_HashSet_map, e, causes);
        }
         else 
          throw $e0;
      }
    }
    if (causes) {
      throw new com_google_gwt_event_shared_UmbrellaException_UmbrellaException__Ljava_util_Set_2V(causes);
    }
  }
   finally {
    --this$static.com_google_gwt_event_shared_SimpleEventBus_firingDepth;
    this$static.com_google_gwt_event_shared_SimpleEventBus_firingDepth == 0 && com_google_gwt_event_shared_SimpleEventBus_$handleQueuedAddsAndRemoves__Lcom_google_gwt_event_shared_SimpleEventBus_2V(this$static);
  }
}

function com_google_gwt_event_shared_SimpleEventBus_$ensureHandlerList__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Ljava_util_List_2(this$static, type){
  var handlers, sourceMap;
  sourceMap = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractHashMap_$get__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_event_shared_SimpleEventBus_map, type), 8);
  if (!sourceMap) {
    sourceMap = new java_util_HashMap_HashMap__V;
    java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_event_shared_SimpleEventBus_map, type, sourceMap);
  }
  handlers = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(sourceMap.java_util_AbstractHashMap_nullSlot, 9);
  if (!handlers) {
    handlers = new java_util_ArrayList_ArrayList__V;
    java_util_AbstractHashMap_$putNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(sourceMap, handlers);
  }
  return handlers;
}

function com_google_gwt_event_shared_SimpleEventBus_$fireEvent__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent_2V(this$static, event){
  if (!event) {
    throw new java_lang_NullPointerException_NullPointerException__Ljava_lang_String_2V($intern_12);
  }
  com_google_gwt_event_shared_SimpleEventBus_$doFire__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent_2Ljava_lang_Object_2V(this$static, event);
}

function com_google_gwt_event_shared_SimpleEventBus_$getHandlerList__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Ljava_util_List_2(this$static, type){
  var handlers, sourceMap;
  sourceMap = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractHashMap_$get__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_event_shared_SimpleEventBus_map, type), 8);
  if (!sourceMap) {
    return java_util_Collections_$clinit__V() , java_util_Collections_$clinit__V() , java_util_Collections_EMPTY_1LIST;
  }
  handlers = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(sourceMap.java_util_AbstractHashMap_nullSlot, 9);
  if (!handlers) {
    return java_util_Collections_$clinit__V() , java_util_Collections_$clinit__V() , java_util_Collections_EMPTY_1LIST;
  }
  return handlers;
}

function com_google_gwt_event_shared_SimpleEventBus_$handleQueuedAddsAndRemoves__Lcom_google_gwt_event_shared_SimpleEventBus_2V(this$static){
  var c, c$iterator;
  if (this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas) {
    try {
      for (c$iterator = new java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas); c$iterator.java_util_AbstractList$IteratorImpl_i < c$iterator.java_util_AbstractList$IteratorImpl_this$0.size__I();) {
        c = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(c$iterator), 10);
        com_google_gwt_event_shared_SimpleEventBus_$doAddNow__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Ljava_lang_Object_2Lcom_google_gwt_event_shared_EventHandler_2V(c.com_google_gwt_event_shared_SimpleEventBus$2_this$0, c.com_google_gwt_event_shared_SimpleEventBus$2_val$type, c.com_google_gwt_event_shared_SimpleEventBus$2_val$handler);
      }
    }
     finally {
      this$static.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas = null;
    }
  }
}

function com_google_gwt_event_shared_SimpleEventBus_SimpleEventBus__ZV(){
  this.com_google_gwt_event_shared_SimpleEventBus_map = new java_util_HashMap_HashMap__V;
  this.com_google_gwt_event_shared_SimpleEventBus_isReverseOrder = false;
}

function com_google_gwt_event_shared_SimpleEventBus(){
}

_ = com_google_gwt_event_shared_SimpleEventBus_SimpleEventBus__ZV.prototype = com_google_gwt_event_shared_SimpleEventBus.prototype = new com_google_gwt_event_shared_EventBus;
_.java_lang_Object_castableTypeMap$ = {18:1};
_.com_google_gwt_event_shared_SimpleEventBus_deferredDeltas = null;
_.com_google_gwt_event_shared_SimpleEventBus_firingDepth = 0;
_.com_google_gwt_event_shared_SimpleEventBus_isReverseOrder = false;
function com_google_gwt_event_shared_SimpleEventBus$1_SimpleEventBus$1__Lcom_google_gwt_event_shared_SimpleEventBus_2V(){
}

function com_google_gwt_event_shared_SimpleEventBus$1(){
}

_ = com_google_gwt_event_shared_SimpleEventBus$1_SimpleEventBus$1__Lcom_google_gwt_event_shared_SimpleEventBus_2V.prototype = com_google_gwt_event_shared_SimpleEventBus$1.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_event_shared_SimpleEventBus$2_SimpleEventBus$2__Lcom_google_gwt_event_shared_SimpleEventBus_2V(this$0, val$type, val$handler){
  this.com_google_gwt_event_shared_SimpleEventBus$2_this$0 = this$0;
  this.com_google_gwt_event_shared_SimpleEventBus$2_val$type = val$type;
  this.com_google_gwt_event_shared_SimpleEventBus$2_val$handler = val$handler;
}

function com_google_gwt_event_shared_SimpleEventBus$2(){
}

_ = com_google_gwt_event_shared_SimpleEventBus$2_SimpleEventBus$2__Lcom_google_gwt_event_shared_SimpleEventBus_2V.prototype = com_google_gwt_event_shared_SimpleEventBus$2.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {10:1};
_.com_google_gwt_event_shared_SimpleEventBus$2_this$0 = null;
_.com_google_gwt_event_shared_SimpleEventBus$2_val$handler = null;
_.com_google_gwt_event_shared_SimpleEventBus$2_val$type = null;
function com_google_gwt_event_shared_UmbrellaException_UmbrellaException__Ljava_util_Set_2V(causes){
  java_lang_RuntimeException_RuntimeException__Ljava_lang_String_2Ljava_lang_Throwable_2V.call(this, causes.java_util_HashSet_map.java_util_AbstractHashMap_size == 0?null:com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(causes.toArray___3Ljava_lang_Object_2_3Ljava_lang_Object_2(com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1Throwable_12_1classLit, {11:1, 23:1}, 7, 0, 0)), 11)[0]);
}

function com_google_gwt_event_shared_UmbrellaException(){
}

_ = com_google_gwt_event_shared_UmbrellaException_UmbrellaException__Ljava_util_Set_2V.prototype = com_google_gwt_event_shared_UmbrellaException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function com_google_gwt_gadgets_client_Gadget(){
}

_ = com_google_gwt_gadgets_client_Gadget.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_i18n_client_BidiUtils_getDirectionOnElement__Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_i18n_client_HasDirection$Direction_2(elem){
  var dirPropertyValue;
  dirPropertyValue = elem[$intern_13] == null?null:String(elem[$intern_13]);
  if (java_lang_String_$equalsIgnoreCase__Ljava_lang_String_2Ljava_lang_String_2Z($intern_14, dirPropertyValue)) {
    return com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V() , com_google_gwt_i18n_client_HasDirection$Direction_RTL;
  }
   else if (java_lang_String_$equalsIgnoreCase__Ljava_lang_String_2Ljava_lang_String_2Z($intern_15, dirPropertyValue)) {
    return com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V() , com_google_gwt_i18n_client_HasDirection$Direction_LTR;
  }
  return com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V() , com_google_gwt_i18n_client_HasDirection$Direction_DEFAULT;
}

function com_google_gwt_i18n_client_BidiUtils_setDirectionOnElement__Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_i18n_client_HasDirection$Direction_2V(elem, direction){
  switch (direction.java_lang_Enum_ordinal) {
    case 0:
      {
        elem[$intern_13] = $intern_14;
        break;
      }

    case 1:
      {
        elem[$intern_13] = $intern_15;
        break;
      }

    case 2:
      {
        com_google_gwt_i18n_client_BidiUtils_getDirectionOnElement__Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_i18n_client_HasDirection$Direction_2(elem) != (com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V() , com_google_gwt_i18n_client_HasDirection$Direction_DEFAULT) && (elem[$intern_13] = $intern_0 , undefined);
        break;
      }

  }
}

function java_lang_Enum(){
}

_ = java_lang_Enum.prototype = new java_lang_Object;
_.equals__Ljava_lang_Object_2Z$ = function java_lang_Enum_equals__Ljava_lang_Object_2Z(other){
  return this === other;
}
;
_.hashCode__I$ = function java_lang_Enum_hashCode__I(){
  return this.$H || (this.$H = ++com_google_gwt_core_client_impl_Impl_sNextHashId);
}
;
_.java_lang_Object_castableTypeMap$ = {23:1, 24:1, 25:1};
_.java_lang_Enum_ordinal = 0;
function com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V(){
  com_google_gwt_i18n_client_HasDirection$Direction_$clinit__V = nullMethod;
  com_google_gwt_i18n_client_HasDirection$Direction_RTL = new com_google_gwt_i18n_client_HasDirection$Direction_HasDirection$Direction__Ljava_lang_String_2IV($intern_16, 0);
  com_google_gwt_i18n_client_HasDirection$Direction_LTR = new com_google_gwt_i18n_client_HasDirection$Direction_HasDirection$Direction__Ljava_lang_String_2IV($intern_17, 1);
  com_google_gwt_i18n_client_HasDirection$Direction_DEFAULT = new com_google_gwt_i18n_client_HasDirection$Direction_HasDirection$Direction__Ljava_lang_String_2IV($intern_18, 2);
  com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Lcom_1google_1gwt_1i18n_1client_1HasDirection$Direction_12_1classLit, {23:1}, 19, [com_google_gwt_i18n_client_HasDirection$Direction_RTL, com_google_gwt_i18n_client_HasDirection$Direction_LTR, com_google_gwt_i18n_client_HasDirection$Direction_DEFAULT]);
}

function com_google_gwt_i18n_client_HasDirection$Direction_HasDirection$Direction__Ljava_lang_String_2IV(enum$name, enum$ordinal){
  this.java_lang_Enum_ordinal = enum$ordinal;
}

function com_google_gwt_i18n_client_HasDirection$Direction(){
}

_ = com_google_gwt_i18n_client_HasDirection$Direction_HasDirection$Direction__Ljava_lang_String_2IV.prototype = com_google_gwt_i18n_client_HasDirection$Direction.prototype = new java_lang_Enum;
_.java_lang_Object_castableTypeMap$ = {19:1, 23:1, 24:1, 25:1};
var com_google_gwt_i18n_client_HasDirection$Direction_DEFAULT, com_google_gwt_i18n_client_HasDirection$Direction_LTR, com_google_gwt_i18n_client_HasDirection$Direction_RTL;
function com_google_gwt_lang_Array_Array__V(){
}

function com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2(array, length){
  var a, result;
  a = array;
  result = com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(0, length);
  com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(a.com_google_gwt_lang_Array_arrayClass$, a.java_lang_Object_castableTypeMap$, a.com_google_gwt_lang_Array_queryId$, result);
  return result;
}

function com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(seedType, length){
  var array = new Array(length);
  if (seedType == 3) {
    for (var i = 0; i < length; ++i) {
      var value = new Object;
      value.l = value.m = value.h = 0;
      array[i] = value;
    }
  }
   else if (seedType > 0) {
    var value = [null, 0, false][seedType];
    for (var i = 0; i < length; ++i) {
      array[i] = value;
    }
  }
  return array;
}

function com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(arrayClass, castableTypeMap, queryId, length, seedType){
  var result;
  result = com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(seedType, length);
  com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V();
  com_google_gwt_lang_Array$ExpandoWrapper_wrapArray__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(result, com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues);
  result.com_google_gwt_lang_Array_arrayClass$ = arrayClass;
  result.java_lang_Object_castableTypeMap$ = castableTypeMap;
  result.com_google_gwt_lang_Array_queryId$ = queryId;
  return result;
}

function com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(arrayClass, castableTypeMap, queryId, array){
  com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V();
  com_google_gwt_lang_Array$ExpandoWrapper_wrapArray__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(array, com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues);
  array.com_google_gwt_lang_Array_arrayClass$ = arrayClass;
  array.java_lang_Object_castableTypeMap$ = castableTypeMap;
  array.com_google_gwt_lang_Array_queryId$ = queryId;
  return array;
}

function com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(array, index, value){
  if (value != null) {
    if (array.com_google_gwt_lang_Array_queryId$ > 0 && !com_google_gwt_lang_Cast_canCastUnsafe__Ljava_lang_Object_2IZ(value, array.com_google_gwt_lang_Array_queryId$)) {
      throw new java_lang_ArrayStoreException_ArrayStoreException__V;
    }
    if (array.com_google_gwt_lang_Array_queryId$ < 0 && (value.java_lang_Object_typeMarker$ == nullMethod || value.java_lang_Object_castableTypeMap$ && !!value.java_lang_Object_castableTypeMap$[1])) {
      throw new java_lang_ArrayStoreException_ArrayStoreException__V;
    }
  }
  return array[index] = value;
}

function com_google_gwt_lang_Array(){
}

_ = com_google_gwt_lang_Array_Array__V.prototype = com_google_gwt_lang_Array.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_lang_Array_arrayClass$ = null;
_.com_google_gwt_lang_Array_queryId$ = 0;
function com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V(){
  com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V = nullMethod;
  com_google_gwt_lang_Array$ExpandoWrapper_expandoNames = [];
  com_google_gwt_lang_Array$ExpandoWrapper_expandoValues = [];
  com_google_gwt_lang_Array$ExpandoWrapper_initExpandos__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(new com_google_gwt_lang_Array_Array__V, com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues);
}

function com_google_gwt_lang_Array$ExpandoWrapper_initExpandos__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(protoType, expandoNames, expandoValues){
  var i = 0, value;
  for (var name in protoType) {
    if (value = protoType[name]) {
      expandoNames[i] = name;
      expandoValues[i] = value;
      ++i;
    }
  }
}

function com_google_gwt_lang_Array$ExpandoWrapper_wrapArray__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(array, expandoNames, expandoValues){
  com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V();
  for (var i = 0, c = expandoNames.length; i < c; ++i) {
    array[expandoNames[i]] = expandoValues[i];
  }
}

var com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues;
function com_google_gwt_lang_Cast_canCastUnsafe__Ljava_lang_Object_2IZ(src, dstId){
  return src.java_lang_Object_castableTypeMap$ && src.java_lang_Object_castableTypeMap$[dstId];
}

function com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(src, dstId){
  if (src != null && !(src.java_lang_Object_castableTypeMap$ && src.java_lang_Object_castableTypeMap$[dstId])) {
    throw new java_lang_ClassCastException_ClassCastException__V;
  }
  return src;
}

function com_google_gwt_lang_Cast_dynamicCastJso__Ljava_lang_Object_2Ljava_lang_Object_2(src){
  if (src != null && (src.java_lang_Object_typeMarker$ == nullMethod || src.java_lang_Object_castableTypeMap$ && !!src.java_lang_Object_castableTypeMap$[1])) {
    throw new java_lang_ClassCastException_ClassCastException__V;
  }
  return src;
}

function com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ(src, dstId){
  return src != null && src.java_lang_Object_castableTypeMap$ && !!src.java_lang_Object_castableTypeMap$[dstId];
}

function com_google_gwt_lang_Cast_instanceOfJso__Ljava_lang_Object_2Z(src){
  return src != null && src.java_lang_Object_typeMarker$ != nullMethod && !(src.java_lang_Object_castableTypeMap$ && !!src.java_lang_Object_castableTypeMap$[1]);
}

function com_google_gwt_lang_Cast_throwClassCastExceptionUnlessNull__Ljava_lang_Object_2Ljava_lang_Object_2(o){
  if (o != null) {
    throw new java_lang_ClassCastException_ClassCastException__V;
  }
  return null;
}

function com_google_gwt_lang_EntryMethodHolder_init__V(){
  !!$stats && $stats({moduleName:$moduleName, sessionId:$sessionId, subSystem:$intern_19, evtGroup:$intern_20, millis:(new Date).getTime(), type:$intern_21, className:$intern_22});
  new eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadgetGadgetImpl_DeploymentGadgetGadgetImpl__V;
}

function com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2(e){
  if (e != null && e.java_lang_Object_castableTypeMap$ && !!e.java_lang_Object_castableTypeMap$[7]) {
    return e;
  }
  return new com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V(e);
}

function com_google_gwt_user_client_DOM_dispatchEvent__Lcom_google_gwt_user_client_Event_2Lcom_google_gwt_user_client_Element_2Lcom_google_gwt_user_client_EventListener_2V(evt, elem, listener){
  var prevCurrentEvent;
  prevCurrentEvent = com_google_gwt_user_client_DOM_currentEvent;
  com_google_gwt_user_client_DOM_currentEvent = evt;
  elem == com_google_gwt_user_client_DOM_sCaptureElem && com_google_gwt_user_client_impl_DOMImpl_$eventGetTypeInt__Lcom_google_gwt_user_client_impl_DOMImpl_2Ljava_lang_String_2I(evt.type) == 8192 && (com_google_gwt_user_client_DOM_sCaptureElem = null);
  listener.onBrowserEvent__Lcom_google_gwt_user_client_Event_2V(evt);
  com_google_gwt_user_client_DOM_currentEvent = prevCurrentEvent;
}

function com_google_gwt_user_client_DOM_previewEvent__Lcom_google_gwt_user_client_Event_2Z(evt){
  return true;
}

function com_google_gwt_user_client_DOM_sinkEvents__Lcom_google_gwt_user_client_Element_2IV(elem, eventBits){
  com_google_gwt_user_client_impl_DOMImpl_$maybeInitializeEventSystem__Lcom_google_gwt_user_client_impl_DOMImpl_2V();
  com_google_gwt_user_client_impl_DOMImplTrident_$sinkEventsImpl__Lcom_google_gwt_user_client_impl_DOMImplTrident_2Lcom_google_gwt_user_client_Element_2IV(elem, eventBits);
}

var com_google_gwt_user_client_DOM_currentEvent = null, com_google_gwt_user_client_DOM_sCaptureElem = null;
function com_google_gwt_user_client_Event_sinkEvents__Lcom_google_gwt_dom_client_Element_2IV(elem, eventBits){
  com_google_gwt_user_client_impl_DOMImpl_$maybeInitializeEventSystem__Lcom_google_gwt_user_client_impl_DOMImpl_2V();
  com_google_gwt_user_client_impl_DOMImplTrident_$sinkEventsImpl__Lcom_google_gwt_user_client_impl_DOMImplTrident_2Lcom_google_gwt_user_client_Element_2IV(elem, eventBits);
}

function com_google_gwt_user_client_Window_addCloseHandler__Lcom_google_gwt_event_logical_shared_CloseHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2(handler){
  com_google_gwt_user_client_Window_maybeInitializeCloseHandlers__V();
  return com_google_gwt_user_client_Window_addHandler__Lcom_google_gwt_event_shared_GwtEvent$Type_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2(com_google_gwt_event_logical_shared_CloseEvent_TYPE?com_google_gwt_event_logical_shared_CloseEvent_TYPE:(com_google_gwt_event_logical_shared_CloseEvent_TYPE = new com_google_gwt_event_shared_GwtEvent$Type_GwtEvent$Type__V), handler);
}

function com_google_gwt_user_client_Window_addHandler__Lcom_google_gwt_event_shared_GwtEvent$Type_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2(type, handler){
  return com_google_gwt_event_shared_SimpleEventBus_$addHandler__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2((!com_google_gwt_user_client_Window_handlers && (com_google_gwt_user_client_Window_handlers = new com_google_gwt_user_client_Window$WindowHandlers_Window$WindowHandlers__V) , com_google_gwt_user_client_Window_handlers).com_google_gwt_event_shared_HandlerManager_eventBus, type, handler);
}

function com_google_gwt_user_client_Window_maybeInitializeCloseHandlers__V(){
  var com_google_gwt_user_client_impl_WindowImplIE_$initHandler__Lcom_google_gwt_user_client_impl_WindowImplIE_2Ljava_lang_String_2Lcom_google_gwt_user_client_Command_2V_scriptElem_0, com_google_gwt_dom_client_DOMImpl_$createScriptElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_ScriptElement_2_elem_0;
  if (!com_google_gwt_user_client_Window_closeHandlersInitialized) {
    com_google_gwt_user_client_impl_WindowImplIE_$initHandler__Lcom_google_gwt_user_client_impl_WindowImplIE_2Ljava_lang_String_2Lcom_google_gwt_user_client_Command_2V_scriptElem_0 = (com_google_gwt_dom_client_DOMImpl_$createScriptElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_ScriptElement_2_elem_0 = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_23) , com_google_gwt_dom_client_DOMImpl_$createScriptElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_ScriptElement_2_elem_0.text = $intern_24 , com_google_gwt_dom_client_DOMImpl_$createScriptElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_ScriptElement_2_elem_0);
    $doc.body.appendChild(com_google_gwt_user_client_impl_WindowImplIE_$initHandler__Lcom_google_gwt_user_client_impl_WindowImplIE_2Ljava_lang_String_2Lcom_google_gwt_user_client_Command_2V_scriptElem_0);
    $wnd.__gwt_initWindowCloseHandler($entry(com_google_gwt_user_client_Window_onClosing__Ljava_lang_String_2), $entry(com_google_gwt_user_client_Window_onClosed__V));
    $doc.body.removeChild(com_google_gwt_user_client_impl_WindowImplIE_$initHandler__Lcom_google_gwt_user_client_impl_WindowImplIE_2Ljava_lang_String_2Lcom_google_gwt_user_client_Command_2V_scriptElem_0);
    com_google_gwt_user_client_Window_closeHandlersInitialized = true;
  }
}

function com_google_gwt_user_client_Window_onClosed__V(){
  com_google_gwt_user_client_Window_closeHandlersInitialized && com_google_gwt_event_logical_shared_CloseEvent_fire__Lcom_google_gwt_event_logical_shared_HasCloseHandlers_2Ljava_lang_Object_2ZV((!com_google_gwt_user_client_Window_handlers && (com_google_gwt_user_client_Window_handlers = new com_google_gwt_user_client_Window$WindowHandlers_Window$WindowHandlers__V) , com_google_gwt_user_client_Window_handlers));
}

function com_google_gwt_user_client_Window_onClosing__Ljava_lang_String_2(){
  var event;
  if (com_google_gwt_user_client_Window_closeHandlersInitialized) {
    event = new com_google_gwt_user_client_Window$ClosingEvent_Window$ClosingEvent__V;
    !!com_google_gwt_user_client_Window_handlers && com_google_gwt_event_shared_HandlerManager_$fireEvent__Lcom_google_gwt_event_shared_HandlerManager_2Lcom_google_gwt_event_shared_GwtEvent_2V(com_google_gwt_user_client_Window_handlers, event);
    return null;
  }
  return null;
}

var com_google_gwt_user_client_Window_closeHandlersInitialized = false, com_google_gwt_user_client_Window_handlers = null;
function com_google_gwt_user_client_Window$ClosingEvent_$clinit__V(){
  com_google_gwt_user_client_Window$ClosingEvent_$clinit__V = nullMethod;
  com_google_gwt_user_client_Window$ClosingEvent_TYPE = new com_google_gwt_event_shared_GwtEvent$Type_GwtEvent$Type__V;
}

function com_google_gwt_user_client_Window$ClosingEvent_Window$ClosingEvent__V(){
  com_google_gwt_user_client_Window$ClosingEvent_$clinit__V();
}

function com_google_gwt_user_client_Window$ClosingEvent(){
}

_ = com_google_gwt_user_client_Window$ClosingEvent_Window$ClosingEvent__V.prototype = com_google_gwt_user_client_Window$ClosingEvent.prototype = new com_google_gwt_event_shared_GwtEvent;
_.dispatch__Lcom_google_gwt_event_shared_EventHandler_2V = function com_google_gwt_user_client_Window$ClosingEvent_dispatch__Lcom_google_gwt_event_shared_EventHandler_2V(handler){
  com_google_gwt_lang_Cast_throwClassCastExceptionUnlessNull__Ljava_lang_Object_2Ljava_lang_Object_2(handler);
  null.nullMethod();
}
;
_.getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2 = function com_google_gwt_user_client_Window$ClosingEvent_getAssociatedType__Lcom_google_gwt_event_shared_GwtEvent$Type_2(){
  return com_google_gwt_user_client_Window$ClosingEvent_TYPE;
}
;
_.java_lang_Object_castableTypeMap$ = {};
var com_google_gwt_user_client_Window$ClosingEvent_TYPE;
function com_google_gwt_user_client_Window$WindowHandlers_Window$WindowHandlers__V(){
  this.com_google_gwt_event_shared_HandlerManager_eventBus = new com_google_gwt_event_shared_SimpleEventBus_SimpleEventBus__ZV;
  this.com_google_gwt_event_shared_HandlerManager_source = null;
}

function com_google_gwt_user_client_Window$WindowHandlers(){
}

_ = com_google_gwt_user_client_Window$WindowHandlers_Window$WindowHandlers__V.prototype = com_google_gwt_user_client_Window$WindowHandlers.prototype = new com_google_gwt_event_shared_HandlerManager;
_.java_lang_Object_castableTypeMap$ = {18:1};
function com_google_gwt_user_client_impl_DOMImpl_$eventGetTypeInt__Lcom_google_gwt_user_client_impl_DOMImpl_2Ljava_lang_String_2I(eventType){
  switch (eventType) {
    case $intern_25:
      return 4096;
    case $intern_26:
      return 1024;
    case $intern_9:
      return 1;
    case $intern_27:
      return 2;
    case $intern_28:
      return 2048;
    case $intern_29:
      return 128;
    case $intern_30:
      return 256;
    case $intern_31:
      return 512;
    case $intern_32:
      return 32768;
    case $intern_33:
      return 8192;
    case $intern_34:
      return 4;
    case $intern_35:
      return 64;
    case $intern_36:
      return 32;
    case $intern_37:
      return 16;
    case $intern_38:
      return 8;
    case $intern_39:
      return 16384;
    case $intern_40:
      return 65536;
    case $intern_41:
      return 131072;
    case $intern_42:
      return 131072;
    case $intern_43:
      return 262144;
    case $intern_44:
      return 524288;
    default:return -1;
  }
}

function com_google_gwt_user_client_impl_DOMImpl_$maybeInitializeEventSystem__Lcom_google_gwt_user_client_impl_DOMImpl_2V(){
  if (!com_google_gwt_user_client_impl_DOMImpl_eventSystemIsInitialized) {
    com_google_gwt_user_client_impl_DOMImplTrident_$initEventSystem__Lcom_google_gwt_user_client_impl_DOMImplTrident_2V();
    com_google_gwt_user_client_impl_DOMImpl_eventSystemIsInitialized = true;
  }
}

var com_google_gwt_user_client_impl_DOMImpl_eventSystemIsInitialized = false;
function com_google_gwt_user_client_impl_DOMImplTrident_$initEventSystem__Lcom_google_gwt_user_client_impl_DOMImplTrident_2V(){
  $wnd.__gwt_globalEventArray == null && ($wnd.__gwt_globalEventArray = new Array);
  $wnd.__gwt_globalEventArray[$wnd.__gwt_globalEventArray.length] = $entry(function(){
    return com_google_gwt_user_client_DOM_previewEvent__Lcom_google_gwt_user_client_Event_2Z($wnd.event);
  }
  );
  var dispatchEvent = $entry(function(){
    var oldEventTarget = com_google_gwt_dom_client_DOMImplTrident_currentEventTarget;
    com_google_gwt_dom_client_DOMImplTrident_currentEventTarget = this;
    if ($wnd.event.returnValue == null) {
      $wnd.event.returnValue = true;
      if (!com_google_gwt_user_client_impl_DOMImplTrident_previewEventImpl__Z()) {
        com_google_gwt_dom_client_DOMImplTrident_currentEventTarget = oldEventTarget;
        return;
      }
    }
    var listener, curElem = this;
    while (curElem && !(listener = curElem.__listener)) {
      curElem = curElem.parentElement;
    }
    listener && !com_google_gwt_lang_Cast_instanceOfJso__Ljava_lang_Object_2Z(listener) && listener != null && listener.java_lang_Object_castableTypeMap$ && !!listener.java_lang_Object_castableTypeMap$[12] && com_google_gwt_user_client_DOM_dispatchEvent__Lcom_google_gwt_user_client_Event_2Lcom_google_gwt_user_client_Element_2Lcom_google_gwt_user_client_EventListener_2V($wnd.event, curElem, listener);
    com_google_gwt_dom_client_DOMImplTrident_currentEventTarget = oldEventTarget;
  }
  );
  var dispatchDblClickEvent = $entry(function(){
    var newEvent = $doc.createEventObject();
    $wnd.event.returnValue == null && $wnd.event.srcElement.fireEvent && $wnd.event.srcElement.fireEvent($intern_45, newEvent);
    if (this.__eventBits & 2) {
      dispatchEvent.call(this);
    }
     else if ($wnd.event.returnValue == null) {
      $wnd.event.returnValue = true;
      com_google_gwt_user_client_impl_DOMImplTrident_previewEventImpl__Z();
    }
  }
  );
  var dispatchUnhandledEvent = $entry(function(){
    this.__gwtLastUnhandledEvent = $wnd.event.type;
    dispatchEvent.call(this);
  }
  );
  var moduleName = $moduleName.replace(/\./g, $intern_46);
  $wnd[$intern_47 + moduleName] = dispatchEvent;
  com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent = (new Function($intern_48, $intern_49 + moduleName + $intern_50))($wnd);
  $wnd[$intern_51 + moduleName] = dispatchDblClickEvent;
  com_google_gwt_user_client_impl_DOMImplTrident_callDispatchDblClickEvent = (new Function($intern_48, $intern_52 + moduleName + $intern_53))($wnd);
  $wnd[$intern_54 + moduleName] = dispatchUnhandledEvent;
  com_google_gwt_user_client_impl_DOMImplTrident_callDispatchUnhandledEvent = (new Function($intern_48, $intern_55 + moduleName + $intern_53))($wnd);
  var bodyDispatcher = $entry(function(){
    dispatchEvent.call($doc.body);
  }
  );
  var bodyDblClickDispatcher = $entry(function(){
    dispatchDblClickEvent.call($doc.body);
  }
  );
  $doc.body.attachEvent($intern_45, bodyDispatcher);
  $doc.body.attachEvent($intern_56, bodyDispatcher);
  $doc.body.attachEvent($intern_57, bodyDispatcher);
  $doc.body.attachEvent($intern_58, bodyDispatcher);
  $doc.body.attachEvent($intern_59, bodyDispatcher);
  $doc.body.attachEvent($intern_60, bodyDispatcher);
  $doc.body.attachEvent($intern_61, bodyDispatcher);
  $doc.body.attachEvent($intern_62, bodyDispatcher);
  $doc.body.attachEvent($intern_63, bodyDispatcher);
  $doc.body.attachEvent($intern_64, bodyDispatcher);
  $doc.body.attachEvent($intern_65, bodyDblClickDispatcher);
  $doc.body.attachEvent($intern_66, bodyDispatcher);
}

function com_google_gwt_user_client_impl_DOMImplTrident_$sinkEventsImpl__Lcom_google_gwt_user_client_impl_DOMImplTrident_2Lcom_google_gwt_user_client_Element_2IV(elem, bits){
  var chMask = (elem.__eventBits || 0) ^ bits;
  elem.__eventBits = bits;
  if (!chMask)
    return;
  chMask & 1 && (elem.onclick = bits & 1?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 3 && (elem.ondblclick = bits & 3?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchDblClickEvent:null);
  chMask & 4 && (elem.onmousedown = bits & 4?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 8 && (elem.onmouseup = bits & 8?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 16 && (elem.onmouseover = bits & 16?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 32 && (elem.onmouseout = bits & 32?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 64 && (elem.onmousemove = bits & 64?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 128 && (elem.onkeydown = bits & 128?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 256 && (elem.onkeypress = bits & 256?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 512 && (elem.onkeyup = bits & 512?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 1024 && (elem.onchange = bits & 1024?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 2048 && (elem.onfocus = bits & 2048?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 4096 && (elem.onblur = bits & 4096?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 8192 && (elem.onlosecapture = bits & 8192?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 16384 && (elem.onscroll = bits & 16384?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 32768 && (elem.onload = bits & 32768?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchUnhandledEvent:null);
  chMask & 65536 && (elem.onerror = bits & 65536?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 131072 && (elem.onmousewheel = bits & 131072?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 262144 && (elem.oncontextmenu = bits & 262144?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
  chMask & 524288 && (elem.onpaste = bits & 524288?com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent:null);
}

function com_google_gwt_user_client_impl_DOMImplTrident_previewEventImpl__Z(){
  var isCancelled = false;
  for (var i = 0; i < $wnd.__gwt_globalEventArray.length; i++) {
    !$wnd.__gwt_globalEventArray[i]() && (isCancelled = true);
  }
  return !isCancelled;
}

var com_google_gwt_user_client_impl_DOMImplTrident_callDispatchDblClickEvent = null, com_google_gwt_user_client_impl_DOMImplTrident_callDispatchEvent = null, com_google_gwt_user_client_impl_DOMImplTrident_callDispatchUnhandledEvent = null;
function com_google_gwt_user_client_ui_UIObject_$setElement__Lcom_google_gwt_user_client_ui_UIObject_2Lcom_google_gwt_user_client_Element_2V(this$static, elem){
  this$static.com_google_gwt_user_client_ui_UIObject_element = elem;
}

function com_google_gwt_user_client_ui_UIObject(){
}

_ = com_google_gwt_user_client_ui_UIObject.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {22:1};
_.com_google_gwt_user_client_ui_UIObject_element = null;
function com_google_gwt_user_client_ui_Widget_$addDomHandler__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_dom_client_DomEvent$Type_2Lcom_google_gwt_event_shared_HandlerRegistration_2(this$static, handler, type){
  com_google_gwt_user_client_ui_Widget_$sinkEvents__Lcom_google_gwt_user_client_ui_Widget_2IV(this$static, com_google_gwt_user_client_impl_DOMImpl_$eventGetTypeInt__Lcom_google_gwt_user_client_impl_DOMImpl_2Ljava_lang_String_2I(type.com_google_gwt_event_dom_client_DomEvent$Type_name));
  return com_google_gwt_event_shared_SimpleEventBus_$addHandler__Lcom_google_gwt_event_shared_SimpleEventBus_2Lcom_google_gwt_event_shared_GwtEvent$Type_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2((!this$static.com_google_gwt_user_client_ui_Widget_handlerManager?(this$static.com_google_gwt_user_client_ui_Widget_handlerManager = new com_google_gwt_event_shared_HandlerManager_HandlerManager__Ljava_lang_Object_2V(this$static)):this$static.com_google_gwt_user_client_ui_Widget_handlerManager).com_google_gwt_event_shared_HandlerManager_eventBus, type, handler);
}

function com_google_gwt_user_client_ui_Widget_$fireEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_event_shared_GwtEvent_2V(this$static, event){
  !!this$static.com_google_gwt_user_client_ui_Widget_handlerManager && com_google_gwt_event_shared_HandlerManager_$fireEvent__Lcom_google_gwt_event_shared_HandlerManager_2Lcom_google_gwt_event_shared_GwtEvent_2V(this$static.com_google_gwt_user_client_ui_Widget_handlerManager, event);
}

function com_google_gwt_user_client_ui_Widget_$onAttach__Lcom_google_gwt_user_client_ui_Widget_2V(this$static){
  var bitsToAdd;
  if (this$static.isAttached__Z()) {
    throw new java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V($intern_67);
  }
  this$static.com_google_gwt_user_client_ui_Widget_attached = true;
  this$static.com_google_gwt_user_client_ui_UIObject_element.__listener = this$static;
  bitsToAdd = this$static.com_google_gwt_user_client_ui_Widget_eventsToSink;
  this$static.com_google_gwt_user_client_ui_Widget_eventsToSink = -1;
  bitsToAdd > 0 && this$static.sinkEvents__IV(bitsToAdd);
  this$static.doAttachChildren__V();
  this$static.onLoad__V();
}

function com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this$static, event){
  var related;
  switch (com_google_gwt_user_client_impl_DOMImpl_$eventGetTypeInt__Lcom_google_gwt_user_client_impl_DOMImpl_2Ljava_lang_String_2I(event.type)) {
    case 16:
    case 32:
      related = event.relatedTarget || (event.type == $intern_36?event.toElement:event.fromElement);
      if (!!related && com_google_gwt_dom_client_DOMImplTrident_$isOrHasChild__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Node_2Z(this$static.com_google_gwt_user_client_ui_UIObject_element, related)) {
        return;
      }

  }
  com_google_gwt_event_dom_client_DomEvent_fireNativeEvent__Lcom_google_gwt_dom_client_NativeEvent_2Lcom_google_gwt_event_shared_HasHandlers_2Lcom_google_gwt_dom_client_Element_2V(event, this$static, this$static.com_google_gwt_user_client_ui_UIObject_element);
}

function com_google_gwt_user_client_ui_Widget_$onDetach__Lcom_google_gwt_user_client_ui_Widget_2V(this$static){
  if (!this$static.isAttached__Z()) {
    throw new java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V($intern_68);
  }
  try {
    this$static.onUnload__V();
  }
   finally {
    try {
      this$static.doDetachChildren__V();
    }
     finally {
      this$static.com_google_gwt_user_client_ui_UIObject_element.__listener = null;
      this$static.com_google_gwt_user_client_ui_Widget_attached = false;
    }
  }
}

function com_google_gwt_user_client_ui_Widget_$removeFromParent__Lcom_google_gwt_user_client_ui_Widget_2V(this$static){
  if (!this$static.com_google_gwt_user_client_ui_Widget_parent) {
    (com_google_gwt_user_client_ui_RootPanel_$clinit__V() , java_util_AbstractHashMap_$containsKey__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Z(com_google_gwt_user_client_ui_RootPanel_widgetsToDetach.java_util_HashSet_map, this$static)) && com_google_gwt_user_client_ui_RootPanel_detachNow__Lcom_google_gwt_user_client_ui_Widget_2V(this$static);
  }
   else if (com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ(this$static.com_google_gwt_user_client_ui_Widget_parent, 15)) {
    com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(this$static.com_google_gwt_user_client_ui_Widget_parent, 15).remove__Lcom_google_gwt_user_client_ui_Widget_2Z(this$static);
  }
   else if (this$static.com_google_gwt_user_client_ui_Widget_parent) {
    throw new java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V($intern_69);
  }
}

function com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, parent){
  var oldParent;
  oldParent = this$static.com_google_gwt_user_client_ui_Widget_parent;
  if (!parent) {
    try {
      !!oldParent && oldParent.isAttached__Z() && this$static.onDetach__V();
    }
     finally {
      this$static.com_google_gwt_user_client_ui_Widget_parent = null;
    }
  }
   else {
    if (oldParent) {
      throw new java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V($intern_70);
    }
    this$static.com_google_gwt_user_client_ui_Widget_parent = parent;
    parent.isAttached__Z() && this$static.onAttach__V();
  }
}

function com_google_gwt_user_client_ui_Widget_$sinkEvents__Lcom_google_gwt_user_client_ui_Widget_2IV(this$static, eventBitsToAdd){
  this$static.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_DOM_sinkEvents__Lcom_google_gwt_user_client_Element_2IV(this$static.com_google_gwt_user_client_ui_UIObject_element, eventBitsToAdd | (this$static.com_google_gwt_user_client_ui_UIObject_element.__eventBits || 0)):(this$static.com_google_gwt_user_client_ui_Widget_eventsToSink |= eventBitsToAdd);
}

function com_google_gwt_user_client_ui_Widget(){
}

_ = com_google_gwt_user_client_ui_Widget.prototype = new com_google_gwt_user_client_ui_UIObject;
_.doAttachChildren__V = function com_google_gwt_user_client_ui_Widget_doAttachChildren__V(){
}
;
_.doDetachChildren__V = function com_google_gwt_user_client_ui_Widget_doDetachChildren__V(){
}
;
_.isAttached__Z = function com_google_gwt_user_client_ui_Widget_isAttached__Z(){
  return this.com_google_gwt_user_client_ui_Widget_attached;
}
;
_.onAttach__V = function com_google_gwt_user_client_ui_Widget_onAttach__V(){
  com_google_gwt_user_client_ui_Widget_$onAttach__Lcom_google_gwt_user_client_ui_Widget_2V(this);
}
;
_.onBrowserEvent__Lcom_google_gwt_user_client_Event_2V = function com_google_gwt_user_client_ui_Widget_onBrowserEvent__Lcom_google_gwt_user_client_Event_2V(event){
  com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this, event);
}
;
_.onDetach__V = function com_google_gwt_user_client_ui_Widget_onDetach__V(){
  com_google_gwt_user_client_ui_Widget_$onDetach__Lcom_google_gwt_user_client_ui_Widget_2V(this);
}
;
_.onLoad__V = function com_google_gwt_user_client_ui_Widget_onLoad__V(){
}
;
_.onUnload__V = function com_google_gwt_user_client_ui_Widget_onUnload__V(){
}
;
_.sinkEvents__IV = function com_google_gwt_user_client_ui_Widget_sinkEvents__IV(eventBitsToAdd){
  this.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_DOM_sinkEvents__Lcom_google_gwt_user_client_Element_2IV(this.com_google_gwt_user_client_ui_UIObject_element, eventBitsToAdd | (this.com_google_gwt_user_client_ui_UIObject_element.__eventBits || 0)):(this.com_google_gwt_user_client_ui_Widget_eventsToSink |= eventBitsToAdd);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_Widget_attached = false;
_.com_google_gwt_user_client_ui_Widget_eventsToSink = 0;
_.com_google_gwt_user_client_ui_Widget_handlerManager = null;
_.com_google_gwt_user_client_ui_Widget_parent = null;
function com_google_gwt_user_client_ui_Panel(){
}

_ = com_google_gwt_user_client_ui_Panel.prototype = new com_google_gwt_user_client_ui_Widget;
_.doAttachChildren__V = function com_google_gwt_user_client_ui_Panel_doAttachChildren__V(){
  com_google_gwt_user_client_ui_AttachDetachException_tryCommand__Ljava_lang_Iterable_2Lcom_google_gwt_user_client_ui_AttachDetachException$Command_2V(this, (com_google_gwt_user_client_ui_AttachDetachException_$clinit__V() , com_google_gwt_user_client_ui_AttachDetachException_attachCommand));
}
;
_.doDetachChildren__V = function com_google_gwt_user_client_ui_Panel_doDetachChildren__V(){
  com_google_gwt_user_client_ui_AttachDetachException_tryCommand__Ljava_lang_Iterable_2Lcom_google_gwt_user_client_ui_AttachDetachException$Command_2V(this, (com_google_gwt_user_client_ui_AttachDetachException_$clinit__V() , com_google_gwt_user_client_ui_AttachDetachException_detachCommand));
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_ComplexPanel_$add__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Element_2V(this$static, child, container){
  com_google_gwt_user_client_ui_Widget_$removeFromParent__Lcom_google_gwt_user_client_ui_Widget_2V(child);
  com_google_gwt_user_client_ui_WidgetCollection_$add__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static.com_google_gwt_user_client_ui_ComplexPanel_children, child);
  container.appendChild(child.com_google_gwt_user_client_ui_UIObject_element);
  com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(child, this$static);
}

function com_google_gwt_user_client_ui_ComplexPanel_$remove__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Z(this$static, w){
  var elem;
  if (w.com_google_gwt_user_client_ui_Widget_parent != this$static) {
    return false;
  }
  try {
    com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(w, null);
  }
   finally {
    elem = w.com_google_gwt_user_client_ui_UIObject_element;
    com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2(elem).removeChild(elem);
    com_google_gwt_user_client_ui_WidgetCollection_$remove__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static.com_google_gwt_user_client_ui_ComplexPanel_children, w);
  }
  return true;
}

function com_google_gwt_user_client_ui_ComplexPanel(){
}

_ = com_google_gwt_user_client_ui_ComplexPanel.prototype = new com_google_gwt_user_client_ui_Panel;
_.iterator__Ljava_util_Iterator_2 = function com_google_gwt_user_client_ui_ComplexPanel_iterator__Ljava_util_Iterator_2(){
  return new com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_WidgetCollection$WidgetIterator__Lcom_google_gwt_user_client_ui_WidgetCollection_2V(this.com_google_gwt_user_client_ui_ComplexPanel_children);
}
;
_.remove__Lcom_google_gwt_user_client_ui_Widget_2Z = function com_google_gwt_user_client_ui_ComplexPanel_remove__Lcom_google_gwt_user_client_ui_Widget_2Z(w){
  return com_google_gwt_user_client_ui_ComplexPanel_$remove__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Z(this, w);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_AbsolutePanel_$add__Lcom_google_gwt_user_client_ui_AbsolutePanel_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, w){
  com_google_gwt_user_client_ui_ComplexPanel_$add__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Element_2V(this$static, w, this$static.com_google_gwt_user_client_ui_UIObject_element);
}

function com_google_gwt_user_client_ui_AbsolutePanel_changeToStaticPositioning__Lcom_google_gwt_user_client_Element_2V(elem){
  elem.style[$intern_71] = $intern_0;
  elem.style[$intern_72] = $intern_0;
  elem.style[$intern_73] = $intern_0;
}

function com_google_gwt_user_client_ui_AbsolutePanel(){
}

_ = com_google_gwt_user_client_ui_AbsolutePanel.prototype = new com_google_gwt_user_client_ui_ComplexPanel;
_.remove__Lcom_google_gwt_user_client_ui_Widget_2Z = function com_google_gwt_user_client_ui_AbsolutePanel_remove__Lcom_google_gwt_user_client_ui_Widget_2Z(w){
  var removed;
  removed = com_google_gwt_user_client_ui_ComplexPanel_$remove__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Z(this, w);
  removed && com_google_gwt_user_client_ui_AbsolutePanel_changeToStaticPositioning__Lcom_google_gwt_user_client_Element_2V(w.com_google_gwt_user_client_ui_UIObject_element);
  return removed;
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_AttachDetachException_$clinit__V(){
  com_google_gwt_user_client_ui_AttachDetachException_$clinit__V = nullMethod;
  com_google_gwt_user_client_ui_AttachDetachException_attachCommand = new com_google_gwt_user_client_ui_AttachDetachException$1_AttachDetachException$1__V;
  com_google_gwt_user_client_ui_AttachDetachException_detachCommand = new com_google_gwt_user_client_ui_AttachDetachException$2_AttachDetachException$2__V;
}

function com_google_gwt_user_client_ui_AttachDetachException_AttachDetachException__Ljava_util_Set_2V(causes){
  com_google_gwt_event_shared_UmbrellaException_UmbrellaException__Ljava_util_Set_2V.call(this, causes);
}

function com_google_gwt_user_client_ui_AttachDetachException_tryCommand__Ljava_lang_Iterable_2Lcom_google_gwt_user_client_ui_AttachDetachException$Command_2V(hasWidgets, c){
  var java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0;
  com_google_gwt_user_client_ui_AttachDetachException_$clinit__V();
  var $e0, caught, e, w, w$iterator;
  caught = null;
  for (w$iterator = hasWidgets.iterator__Ljava_util_Iterator_2(); w$iterator.hasNext__Z();) {
    w = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(w$iterator.next__Ljava_lang_Object_2(), 13);
    try {
      c.execute__Lcom_google_gwt_user_client_ui_Widget_2V(w);
    }
     catch ($e0) {
      $e0 = com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2($e0);
      if (com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ($e0, 7)) {
        e = $e0;
        !caught && (caught = new java_util_HashSet_HashSet__V);
        java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0 = java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(caught.java_util_HashSet_map, e, caught);
      }
       else 
        throw $e0;
    }
  }
  if (caught) {
    throw new com_google_gwt_user_client_ui_AttachDetachException_AttachDetachException__Ljava_util_Set_2V(caught);
  }
}

function com_google_gwt_user_client_ui_AttachDetachException(){
}

_ = com_google_gwt_user_client_ui_AttachDetachException_AttachDetachException__Ljava_util_Set_2V.prototype = com_google_gwt_user_client_ui_AttachDetachException.prototype = new com_google_gwt_event_shared_UmbrellaException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
var com_google_gwt_user_client_ui_AttachDetachException_attachCommand, com_google_gwt_user_client_ui_AttachDetachException_detachCommand;
function com_google_gwt_user_client_ui_AttachDetachException$1_AttachDetachException$1__V(){
}

function com_google_gwt_user_client_ui_AttachDetachException$1(){
}

_ = com_google_gwt_user_client_ui_AttachDetachException$1_AttachDetachException$1__V.prototype = com_google_gwt_user_client_ui_AttachDetachException$1.prototype = new java_lang_Object;
_.execute__Lcom_google_gwt_user_client_ui_Widget_2V = function com_google_gwt_user_client_ui_AttachDetachException$1_execute__Lcom_google_gwt_user_client_ui_Widget_2V(w){
  w.onAttach__V();
}
;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_user_client_ui_AttachDetachException$2_AttachDetachException$2__V(){
}

function com_google_gwt_user_client_ui_AttachDetachException$2(){
}

_ = com_google_gwt_user_client_ui_AttachDetachException$2_AttachDetachException$2__V.prototype = com_google_gwt_user_client_ui_AttachDetachException$2.prototype = new java_lang_Object;
_.execute__Lcom_google_gwt_user_client_ui_Widget_2V = function com_google_gwt_user_client_ui_AttachDetachException$2_execute__Lcom_google_gwt_user_client_ui_Widget_2V(w){
  w.onDetach__V();
}
;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_user_client_ui_FocusWidget(){
}

_ = com_google_gwt_user_client_ui_FocusWidget.prototype = new com_google_gwt_user_client_ui_Widget;
_.getTabIndex__I = function com_google_gwt_user_client_ui_FocusWidget_getTabIndex__I(){
  return this.com_google_gwt_user_client_ui_UIObject_element.tabIndex;
}
;
_.onAttach__V = function com_google_gwt_user_client_ui_FocusWidget_onAttach__V(){
  var tabIndex;
  com_google_gwt_user_client_ui_Widget_$onAttach__Lcom_google_gwt_user_client_ui_Widget_2V(this);
  tabIndex = this.getTabIndex__I();
  -1 == tabIndex && this.setTabIndex__IV(0);
}
;
_.setTabIndex__IV = function com_google_gwt_user_client_ui_FocusWidget_setTabIndex__IV(index){
  this.com_google_gwt_user_client_ui_UIObject_element.tabIndex = index;
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_ButtonBase(){
}

_ = com_google_gwt_user_client_ui_ButtonBase.prototype = new com_google_gwt_user_client_ui_FocusWidget;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_Button_Button__Ljava_lang_String_2V(){
  this.com_google_gwt_user_client_ui_UIObject_element = $doc.createElement($intern_74);
  this.com_google_gwt_user_client_ui_UIObject_element[$intern_75] = $intern_76;
  this.com_google_gwt_user_client_ui_UIObject_element.innerHTML = $intern_77;
}

function com_google_gwt_user_client_ui_Button(){
}

_ = com_google_gwt_user_client_ui_Button_Button__Ljava_lang_String_2V.prototype = com_google_gwt_user_client_ui_Button.prototype = new com_google_gwt_user_client_ui_ButtonBase;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_CellPanel_$getWidgetTd__Lcom_google_gwt_user_client_ui_CellPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Element_2(this$static, w){
  var com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0;
  if (w.com_google_gwt_user_client_ui_Widget_parent != this$static) {
    return null;
  }
  return com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = w.com_google_gwt_user_client_ui_UIObject_element.parentNode , (!com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 || com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0.nodeType != 1) && (com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = null) , com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0;
}

function com_google_gwt_user_client_ui_CellPanel_$setCellVerticalAlignment__Lcom_google_gwt_user_client_ui_CellPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_2V(this$static, w, align){
  var td;
  td = com_google_gwt_user_client_ui_CellPanel_$getWidgetTd__Lcom_google_gwt_user_client_ui_CellPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Element_2(this$static, w);
  !!td && (td.style[$intern_78] = align.com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_verticalAlignString , undefined);
}

function com_google_gwt_user_client_ui_CellPanel_CellPanel__V(){
  this.com_google_gwt_user_client_ui_ComplexPanel_children = new com_google_gwt_user_client_ui_WidgetCollection_WidgetCollection__Lcom_google_gwt_user_client_ui_HasWidgets_2V;
  this.com_google_gwt_user_client_ui_CellPanel_table = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_79);
  this.com_google_gwt_user_client_ui_CellPanel_body = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_80);
  this.com_google_gwt_user_client_ui_CellPanel_table.appendChild(this.com_google_gwt_user_client_ui_CellPanel_body);
  this.com_google_gwt_user_client_ui_UIObject_element = this.com_google_gwt_user_client_ui_CellPanel_table;
}

function com_google_gwt_user_client_ui_CellPanel(){
}

_ = com_google_gwt_user_client_ui_CellPanel.prototype = new com_google_gwt_user_client_ui_ComplexPanel;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_CellPanel_body = null;
_.com_google_gwt_user_client_ui_CellPanel_table = null;
function com_google_gwt_user_client_ui_CheckBox_$isChecked__Lcom_google_gwt_user_client_ui_CheckBox_2Z(this$static){
  return (this$static.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE)).java_lang_Boolean_value;
}

function com_google_gwt_user_client_ui_CheckBox_$setValue__Lcom_google_gwt_user_client_ui_CheckBox_2Ljava_lang_Boolean_2ZV(this$static, value){
  var oldValue;
  !value && (value = (java_lang_Boolean_$clinit__V() , java_lang_Boolean_FALSE));
  oldValue = this$static.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE);
  this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.checked = value.java_lang_Boolean_value;
  this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked = value.java_lang_Boolean_value;
  if (!!oldValue && oldValue.java_lang_Boolean_value == value.java_lang_Boolean_value) {
    return;
  }
}

function com_google_gwt_user_client_ui_CheckBox_CheckBox__Lcom_google_gwt_user_client_Element_2V(elem){
  var uid;
  this.com_google_gwt_user_client_ui_UIObject_element = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_81);
  this.com_google_gwt_user_client_ui_CheckBox_inputElem = elem;
  this.com_google_gwt_user_client_ui_CheckBox_labelElem = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_82);
  this.com_google_gwt_user_client_ui_UIObject_element.appendChild(this.com_google_gwt_user_client_ui_CheckBox_inputElem);
  this.com_google_gwt_user_client_ui_UIObject_element.appendChild(this.com_google_gwt_user_client_ui_CheckBox_labelElem);
  uid = com_google_gwt_dom_client_Document_$createUniqueId__Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2($doc);
  this.com_google_gwt_user_client_ui_CheckBox_inputElem[$intern_83] = uid;
  this.com_google_gwt_user_client_ui_CheckBox_labelElem.htmlFor = uid;
  !!this.com_google_gwt_user_client_ui_CheckBox_inputElem && (this.com_google_gwt_user_client_ui_CheckBox_inputElem.tabIndex = 0 , undefined);
}

function com_google_gwt_user_client_ui_CheckBox(){
}

_ = com_google_gwt_user_client_ui_CheckBox.prototype = new com_google_gwt_user_client_ui_ButtonBase;
_.getTabIndex__I = function com_google_gwt_user_client_ui_CheckBox_getTabIndex__I(){
  return this.com_google_gwt_user_client_ui_CheckBox_inputElem.tabIndex;
}
;
_.onLoad__V = function com_google_gwt_user_client_ui_CheckBox_onLoad__V(){
  this.com_google_gwt_user_client_ui_CheckBox_inputElem.__listener = this;
}
;
_.onUnload__V = function com_google_gwt_user_client_ui_CheckBox_onUnload__V(){
  this.com_google_gwt_user_client_ui_CheckBox_inputElem.__listener = null;
  com_google_gwt_user_client_ui_CheckBox_$setValue__Lcom_google_gwt_user_client_ui_CheckBox_2Ljava_lang_Boolean_2ZV(this, this.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE));
}
;
_.setTabIndex__IV = function com_google_gwt_user_client_ui_CheckBox_setTabIndex__IV(index){
  !!this.com_google_gwt_user_client_ui_CheckBox_inputElem && (this.com_google_gwt_user_client_ui_CheckBox_inputElem.tabIndex = index , undefined);
}
;
_.sinkEvents__IV = function com_google_gwt_user_client_ui_CheckBox_sinkEvents__IV(eventBitsToAdd){
  this.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_Event_sinkEvents__Lcom_google_gwt_dom_client_Element_2IV(this.com_google_gwt_user_client_ui_CheckBox_inputElem, eventBitsToAdd | (this.com_google_gwt_user_client_ui_CheckBox_inputElem.__eventBits || 0)):this.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_DOM_sinkEvents__Lcom_google_gwt_user_client_Element_2IV(this.com_google_gwt_user_client_ui_UIObject_element, eventBitsToAdd | (this.com_google_gwt_user_client_ui_UIObject_element.__eventBits || 0)):(this.com_google_gwt_user_client_ui_Widget_eventsToSink |= eventBitsToAdd);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_CheckBox_inputElem = null;
_.com_google_gwt_user_client_ui_CheckBox_labelElem = null;
function com_google_gwt_user_client_ui_Composite_$initWidget__Lcom_google_gwt_user_client_ui_Composite_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, widget){
  if (this$static.com_google_gwt_user_client_ui_Composite_widget) {
    throw new java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V($intern_84);
  }
  com_google_gwt_user_client_ui_Widget_$removeFromParent__Lcom_google_gwt_user_client_ui_Widget_2V(widget);
  com_google_gwt_user_client_ui_UIObject_$setElement__Lcom_google_gwt_user_client_ui_UIObject_2Lcom_google_gwt_user_client_Element_2V(this$static, widget.com_google_gwt_user_client_ui_UIObject_element);
  this$static.com_google_gwt_user_client_ui_Composite_widget = widget;
  com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(widget, this$static);
}

function com_google_gwt_user_client_ui_Composite(){
}

_ = com_google_gwt_user_client_ui_Composite.prototype = new com_google_gwt_user_client_ui_Widget;
_.isAttached__Z = function com_google_gwt_user_client_ui_Composite_isAttached__Z(){
  if (this.com_google_gwt_user_client_ui_Composite_widget) {
    return this.com_google_gwt_user_client_ui_Composite_widget.com_google_gwt_user_client_ui_Widget_attached;
  }
  return false;
}
;
_.onAttach__V = function com_google_gwt_user_client_ui_Composite_onAttach__V(){
  if (this.com_google_gwt_user_client_ui_Widget_eventsToSink != -1) {
    com_google_gwt_user_client_ui_Widget_$sinkEvents__Lcom_google_gwt_user_client_ui_Widget_2IV(this.com_google_gwt_user_client_ui_Composite_widget, this.com_google_gwt_user_client_ui_Widget_eventsToSink);
    this.com_google_gwt_user_client_ui_Widget_eventsToSink = -1;
  }
  com_google_gwt_user_client_ui_Widget_$onAttach__Lcom_google_gwt_user_client_ui_Widget_2V(this.com_google_gwt_user_client_ui_Composite_widget);
  this.com_google_gwt_user_client_ui_UIObject_element.__listener = this;
}
;
_.onBrowserEvent__Lcom_google_gwt_user_client_Event_2V = function com_google_gwt_user_client_ui_Composite_onBrowserEvent__Lcom_google_gwt_user_client_Event_2V(event){
  com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this, event);
  com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this.com_google_gwt_user_client_ui_Composite_widget, event);
}
;
_.onDetach__V = function com_google_gwt_user_client_ui_Composite_onDetach__V(){
  com_google_gwt_user_client_ui_Widget_$onDetach__Lcom_google_gwt_user_client_ui_Widget_2V(this.com_google_gwt_user_client_ui_Composite_widget);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_Composite_widget = null;
function com_google_gwt_user_client_ui_DirectionalTextHelper_$setTextOrHtml__Lcom_google_gwt_user_client_ui_DirectionalTextHelper_2Ljava_lang_String_2ZV(this$static, content){
  this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_element.innerText = content || $intern_0;
  if (this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_textDir != this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir) {
    this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_textDir = this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir;
    com_google_gwt_i18n_client_BidiUtils_setDirectionOnElement__Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_i18n_client_HasDirection$Direction_2V(this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_element, this$static.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir);
  }
}

function com_google_gwt_user_client_ui_DirectionalTextHelper_DirectionalTextHelper__Lcom_google_gwt_dom_client_Element_2ZV(element){
  this.com_google_gwt_user_client_ui_DirectionalTextHelper_element = element;
  this.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir = com_google_gwt_i18n_client_BidiUtils_getDirectionOnElement__Lcom_google_gwt_dom_client_Element_2Lcom_google_gwt_i18n_client_HasDirection$Direction_2(element);
  this.com_google_gwt_user_client_ui_DirectionalTextHelper_textDir = this.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir;
}

function com_google_gwt_user_client_ui_DirectionalTextHelper(){
}

_ = com_google_gwt_user_client_ui_DirectionalTextHelper_DirectionalTextHelper__Lcom_google_gwt_dom_client_Element_2ZV.prototype = com_google_gwt_user_client_ui_DirectionalTextHelper.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_user_client_ui_DirectionalTextHelper_element = null;
_.com_google_gwt_user_client_ui_DirectionalTextHelper_initialElementDir = null;
_.com_google_gwt_user_client_ui_DirectionalTextHelper_textDir = null;
function com_google_gwt_user_client_ui_FileUpload_FileUpload__V(){
  var com_google_gwt_dom_client_DOMImpl_$createInputElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_InputElement_2_e_0;
  this.com_google_gwt_user_client_ui_UIObject_element = (com_google_gwt_dom_client_DOMImpl_$createInputElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_InputElement_2_e_0 = $doc.createElement($intern_85) , com_google_gwt_dom_client_DOMImpl_$createInputElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_InputElement_2_e_0.type = $intern_86 , com_google_gwt_dom_client_DOMImpl_$createInputElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_InputElement_2_e_0);
  this.com_google_gwt_user_client_ui_UIObject_element[$intern_75] = $intern_87;
}

function com_google_gwt_user_client_ui_FileUpload(){
}

_ = com_google_gwt_user_client_ui_FileUpload_FileUpload__V.prototype = com_google_gwt_user_client_ui_FileUpload.prototype = new com_google_gwt_user_client_ui_Widget;
_.onBrowserEvent__Lcom_google_gwt_user_client_Event_2V = function com_google_gwt_user_client_ui_FileUpload_onBrowserEvent__Lcom_google_gwt_user_client_Event_2V(event){
  com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this, event);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_HasHorizontalAlignment_$clinit__V(){
  com_google_gwt_user_client_ui_HasHorizontalAlignment_$clinit__V = nullMethod;
  new com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V($intern_88);
  new com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V($intern_89);
  com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LEFT = new com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V($intern_71);
  new com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V($intern_90);
  com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LOCALE_1START = com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LEFT;
  com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1DEFAULT = com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LOCALE_1START;
}

var com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1DEFAULT, com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LEFT, com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1LOCALE_1START;
function com_google_gwt_user_client_ui_HasHorizontalAlignment$AutoHorizontalAlignmentConstant(){
}

_ = com_google_gwt_user_client_ui_HasHorizontalAlignment$AutoHorizontalAlignmentConstant.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V(textAlignString){
  this.com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_textAlignString = textAlignString;
}

function com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant(){
}

_ = com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_HasHorizontalAlignment$HorizontalAlignmentConstant__Ljava_lang_String_2V.prototype = com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant.prototype = new com_google_gwt_user_client_ui_HasHorizontalAlignment$AutoHorizontalAlignmentConstant;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_textAlignString = null;
function com_google_gwt_user_client_ui_HasVerticalAlignment_$clinit__V(){
  com_google_gwt_user_client_ui_HasVerticalAlignment_$clinit__V = nullMethod;
  new com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_HasVerticalAlignment$VerticalAlignmentConstant__Ljava_lang_String_2V($intern_91);
  com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1MIDDLE = new com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_HasVerticalAlignment$VerticalAlignmentConstant__Ljava_lang_String_2V($intern_92);
  com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1TOP = new com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_HasVerticalAlignment$VerticalAlignmentConstant__Ljava_lang_String_2V($intern_72);
}

var com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1MIDDLE, com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1TOP;
function com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_HasVerticalAlignment$VerticalAlignmentConstant__Ljava_lang_String_2V(verticalAlignString){
  this.com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_verticalAlignString = verticalAlignString;
}

function com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant(){
}

_ = com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_HasVerticalAlignment$VerticalAlignmentConstant__Ljava_lang_String_2V.prototype = com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_verticalAlignString = null;
function com_google_gwt_user_client_ui_HorizontalPanel_$add__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, w){
  var td, com_google_gwt_user_client_ui_HorizontalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_Element_2_td_0;
  td = (com_google_gwt_user_client_ui_HorizontalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_Element_2_td_0 = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_93) , com_google_gwt_user_client_ui_HorizontalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_Element_2_td_0[$intern_94] = this$static.com_google_gwt_user_client_ui_HorizontalPanel_horzAlign.com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_textAlignString , com_google_gwt_user_client_ui_HorizontalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_Element_2_td_0.style[$intern_78] = this$static.com_google_gwt_user_client_ui_HorizontalPanel_vertAlign.com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_verticalAlignString , com_google_gwt_user_client_ui_HorizontalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_Element_2_td_0);
  this$static.com_google_gwt_user_client_ui_HorizontalPanel_tableRow.appendChild(td);
  com_google_gwt_user_client_ui_Widget_$removeFromParent__Lcom_google_gwt_user_client_ui_Widget_2V(w);
  com_google_gwt_user_client_ui_WidgetCollection_$add__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static.com_google_gwt_user_client_ui_ComplexPanel_children, w);
  td.appendChild(w.com_google_gwt_user_client_ui_UIObject_element);
  com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(w, this$static);
}

function com_google_gwt_user_client_ui_HorizontalPanel_HorizontalPanel__V(){
  com_google_gwt_user_client_ui_CellPanel_CellPanel__V.call(this);
  this.com_google_gwt_user_client_ui_HorizontalPanel_horzAlign = (com_google_gwt_user_client_ui_HasHorizontalAlignment_$clinit__V() , com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1DEFAULT);
  this.com_google_gwt_user_client_ui_HorizontalPanel_vertAlign = (com_google_gwt_user_client_ui_HasVerticalAlignment_$clinit__V() , com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1TOP);
  this.com_google_gwt_user_client_ui_HorizontalPanel_tableRow = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_95);
  this.com_google_gwt_user_client_ui_CellPanel_body.appendChild(this.com_google_gwt_user_client_ui_HorizontalPanel_tableRow);
  this.com_google_gwt_user_client_ui_CellPanel_table[$intern_96] = $intern_97;
  this.com_google_gwt_user_client_ui_CellPanel_table[$intern_98] = $intern_97;
}

function com_google_gwt_user_client_ui_HorizontalPanel(){
}

_ = com_google_gwt_user_client_ui_HorizontalPanel_HorizontalPanel__V.prototype = com_google_gwt_user_client_ui_HorizontalPanel.prototype = new com_google_gwt_user_client_ui_CellPanel;
_.remove__Lcom_google_gwt_user_client_ui_Widget_2Z = function com_google_gwt_user_client_ui_HorizontalPanel_remove__Lcom_google_gwt_user_client_ui_Widget_2Z(w){
  var removed, td, com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0;
  td = (com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = w.com_google_gwt_user_client_ui_UIObject_element.parentNode , (!com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 || com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0.nodeType != 1) && (com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = null) , com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0);
  removed = com_google_gwt_user_client_ui_ComplexPanel_$remove__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Z(this, w);
  removed && this.com_google_gwt_user_client_ui_HorizontalPanel_tableRow.removeChild(td);
  return removed;
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_HorizontalPanel_tableRow = null;
function com_google_gwt_user_client_ui_LabelBase(){
}

_ = com_google_gwt_user_client_ui_LabelBase.prototype = new com_google_gwt_user_client_ui_Widget;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
_.com_google_gwt_user_client_ui_LabelBase_directionalTextHelper = null;
function com_google_gwt_user_client_ui_Label_Label__Ljava_lang_String_2V(text){
  this.com_google_gwt_user_client_ui_UIObject_element = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_5);
  this.com_google_gwt_user_client_ui_LabelBase_directionalTextHelper = new com_google_gwt_user_client_ui_DirectionalTextHelper_DirectionalTextHelper__Lcom_google_gwt_dom_client_Element_2ZV(this.com_google_gwt_user_client_ui_UIObject_element);
  this.com_google_gwt_user_client_ui_UIObject_element[$intern_75] = $intern_99;
  com_google_gwt_user_client_ui_DirectionalTextHelper_$setTextOrHtml__Lcom_google_gwt_user_client_ui_DirectionalTextHelper_2Ljava_lang_String_2ZV(this.com_google_gwt_user_client_ui_LabelBase_directionalTextHelper, text);
}

function com_google_gwt_user_client_ui_Label(){
}

_ = com_google_gwt_user_client_ui_Label_Label__Ljava_lang_String_2V.prototype = com_google_gwt_user_client_ui_Label.prototype = new com_google_gwt_user_client_ui_LabelBase;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_ListBox_$checkIndex__Lcom_google_gwt_user_client_ui_ListBox_2IV(this$static, index){
  if (index < 0 || index >= this$static.com_google_gwt_user_client_ui_UIObject_element.options.length) {
    throw new java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V;
  }
}

function com_google_gwt_user_client_ui_ListBox_$getItemText__Lcom_google_gwt_user_client_ui_ListBox_2ILjava_lang_String_2(this$static, index){
  com_google_gwt_user_client_ui_ListBox_$checkIndex__Lcom_google_gwt_user_client_ui_ListBox_2IV(this$static, index);
  return this$static.com_google_gwt_user_client_ui_UIObject_element.options[index].text;
}

function com_google_gwt_user_client_ui_ListBox_$insertItem__Lcom_google_gwt_user_client_ui_ListBox_2Ljava_lang_String_2Ljava_lang_String_2IV(this$static, item, value){
  var option, select;
  select = this$static.com_google_gwt_user_client_ui_UIObject_element;
  option = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_100);
  option.text = item;
  option.value = value;
  select.add(option);
}

function com_google_gwt_user_client_ui_ListBox_ListBox__V(){
  var com_google_gwt_dom_client_DOMImplTrident_$createSelectElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2ZLcom_google_gwt_dom_client_SelectElement_2_html_0;
  this.com_google_gwt_user_client_ui_UIObject_element = (com_google_gwt_dom_client_DOMImplTrident_$createSelectElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2ZLcom_google_gwt_dom_client_SelectElement_2_html_0 = $intern_101 , $doc.createElement(com_google_gwt_dom_client_DOMImplTrident_$createSelectElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2ZLcom_google_gwt_dom_client_SelectElement_2_html_0));
  this.com_google_gwt_user_client_ui_UIObject_element[$intern_75] = $intern_102;
}

function com_google_gwt_user_client_ui_ListBox(){
}

_ = com_google_gwt_user_client_ui_ListBox_ListBox__V.prototype = com_google_gwt_user_client_ui_ListBox.prototype = new com_google_gwt_user_client_ui_FocusWidget;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this$static, eventBitsToAdd){
  if (this$static.com_google_gwt_user_client_ui_Widget_eventsToSink == -1) {
    com_google_gwt_user_client_Event_sinkEvents__Lcom_google_gwt_dom_client_Element_2IV(this$static.com_google_gwt_user_client_ui_CheckBox_inputElem, eventBitsToAdd | (this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.__eventBits || 0));
    com_google_gwt_user_client_Event_sinkEvents__Lcom_google_gwt_dom_client_Element_2IV(this$static.com_google_gwt_user_client_ui_CheckBox_labelElem, eventBitsToAdd | (this$static.com_google_gwt_user_client_ui_CheckBox_labelElem.__eventBits || 0));
  }
   else {
    this$static.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_Event_sinkEvents__Lcom_google_gwt_dom_client_Element_2IV(this$static.com_google_gwt_user_client_ui_CheckBox_inputElem, eventBitsToAdd | (this$static.com_google_gwt_user_client_ui_CheckBox_inputElem.__eventBits || 0)):this$static.com_google_gwt_user_client_ui_Widget_eventsToSink == -1?com_google_gwt_user_client_DOM_sinkEvents__Lcom_google_gwt_user_client_Element_2IV(this$static.com_google_gwt_user_client_ui_UIObject_element, eventBitsToAdd | (this$static.com_google_gwt_user_client_ui_UIObject_element.__eventBits || 0)):(this$static.com_google_gwt_user_client_ui_Widget_eventsToSink |= eventBitsToAdd);
  }
}

function com_google_gwt_user_client_ui_RadioButton_RadioButton__Ljava_lang_String_2Ljava_lang_String_2V(label){
  com_google_gwt_user_client_ui_CheckBox_CheckBox__Lcom_google_gwt_user_client_Element_2V.call(this, $doc.createElement($intern_103));
  this.com_google_gwt_user_client_ui_UIObject_element[$intern_75] = $intern_104;
  com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this, 1);
  com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this, 8);
  com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this, 4096);
  com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this, 128);
  this.com_google_gwt_user_client_ui_CheckBox_labelElem.innerText = label || $intern_0;
}

function com_google_gwt_user_client_ui_RadioButton(){
}

_ = com_google_gwt_user_client_ui_RadioButton_RadioButton__Ljava_lang_String_2Ljava_lang_String_2V.prototype = com_google_gwt_user_client_ui_RadioButton.prototype = new com_google_gwt_user_client_ui_CheckBox;
_.onBrowserEvent__Lcom_google_gwt_user_client_Event_2V = function com_google_gwt_user_client_ui_RadioButton_onBrowserEvent__Lcom_google_gwt_user_client_Event_2V(event){
  var target;
  switch (com_google_gwt_user_client_impl_DOMImpl_$eventGetTypeInt__Lcom_google_gwt_user_client_impl_DOMImpl_2Ljava_lang_String_2I(event.type)) {
    case 8:
    case 4096:
    case 128:
      this.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE);
      break;
    case 1:
      target = event.srcElement;
      if (com_google_gwt_dom_client_Element_is__Lcom_google_gwt_core_client_JavaScriptObject_2Z(target) && com_google_gwt_dom_client_DOMImplTrident_$isOrHasChild__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Node_2Z(this.com_google_gwt_user_client_ui_CheckBox_labelElem, target)) {
        this.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE);
        return;
      }

      com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this, event);
      com_google_gwt_event_logical_shared_ValueChangeEvent_fireIfNotEqual__Lcom_google_gwt_event_logical_shared_HasValueChangeHandlers_2Ljava_lang_Object_2Ljava_lang_Object_2V(this.com_google_gwt_user_client_ui_Widget_attached?(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.checked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE):(java_lang_Boolean_$clinit__V() , this.com_google_gwt_user_client_ui_CheckBox_inputElem.defaultChecked?java_lang_Boolean_TRUE:java_lang_Boolean_FALSE));
      return;
  }
  com_google_gwt_user_client_ui_Widget_$onBrowserEvent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_Event_2V(this, event);
}
;
_.sinkEvents__IV = function com_google_gwt_user_client_ui_RadioButton_sinkEvents__IV(eventBitsToAdd){
  com_google_gwt_user_client_ui_RadioButton_$sinkEvents__Lcom_google_gwt_user_client_ui_RadioButton_2IV(this, eventBitsToAdd);
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_RootPanel_$clinit__V(){
  com_google_gwt_user_client_ui_RootPanel_$clinit__V = nullMethod;
  com_google_gwt_user_client_ui_RootPanel_maybeDetachCommand = new com_google_gwt_user_client_ui_RootPanel$1_RootPanel$1__V;
  com_google_gwt_user_client_ui_RootPanel_rootPanels = new java_util_HashMap_HashMap__V;
  com_google_gwt_user_client_ui_RootPanel_widgetsToDetach = new java_util_HashSet_HashSet__V;
}

function com_google_gwt_user_client_ui_RootPanel_RootPanel__Lcom_google_gwt_dom_client_Element_2V(elem){
  this.com_google_gwt_user_client_ui_ComplexPanel_children = new com_google_gwt_user_client_ui_WidgetCollection_WidgetCollection__Lcom_google_gwt_user_client_ui_HasWidgets_2V;
  this.com_google_gwt_user_client_ui_UIObject_element = elem;
  com_google_gwt_user_client_ui_Widget_$onAttach__Lcom_google_gwt_user_client_ui_Widget_2V(this);
}

function com_google_gwt_user_client_ui_RootPanel_detachNow__Lcom_google_gwt_user_client_ui_Widget_2V(widget){
  com_google_gwt_user_client_ui_RootPanel_$clinit__V();
  try {
    widget.onDetach__V();
  }
   finally {
    java_util_AbstractHashMap_$remove__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(com_google_gwt_user_client_ui_RootPanel_widgetsToDetach.java_util_HashSet_map, widget) != null;
  }
}

function com_google_gwt_user_client_ui_RootPanel_detachWidgets__V(){
  com_google_gwt_user_client_ui_RootPanel_$clinit__V();
  try {
    com_google_gwt_user_client_ui_AttachDetachException_tryCommand__Ljava_lang_Iterable_2Lcom_google_gwt_user_client_ui_AttachDetachException$Command_2V(com_google_gwt_user_client_ui_RootPanel_widgetsToDetach, com_google_gwt_user_client_ui_RootPanel_maybeDetachCommand);
  }
   finally {
    java_util_AbstractHashMap_$clearImpl__Ljava_util_AbstractHashMap_2V(com_google_gwt_user_client_ui_RootPanel_widgetsToDetach.java_util_HashSet_map);
    java_util_AbstractHashMap_$clearImpl__Ljava_util_AbstractHashMap_2V(com_google_gwt_user_client_ui_RootPanel_rootPanels);
  }
}

function com_google_gwt_user_client_ui_RootPanel_get__Ljava_lang_String_2Lcom_google_gwt_user_client_ui_RootPanel_2(){
  com_google_gwt_user_client_ui_RootPanel_$clinit__V();
  var rp;
  rp = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractHashMap_$get__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(com_google_gwt_user_client_ui_RootPanel_rootPanels, null), 14);
  if (rp) {
    return rp;
  }
  com_google_gwt_user_client_ui_RootPanel_rootPanels.java_util_AbstractHashMap_size == 0 && com_google_gwt_user_client_Window_addCloseHandler__Lcom_google_gwt_event_logical_shared_CloseHandler_2Lcom_google_gwt_event_shared_HandlerRegistration_2(new com_google_gwt_user_client_ui_RootPanel$2_RootPanel$2__V);
  rp = new com_google_gwt_user_client_ui_RootPanel$DefaultRootPanel_RootPanel$DefaultRootPanel__V;
  java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(com_google_gwt_user_client_ui_RootPanel_rootPanels, null, rp);
  java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z(com_google_gwt_user_client_ui_RootPanel_widgetsToDetach, rp);
  return rp;
}

function com_google_gwt_user_client_ui_RootPanel(){
}

_ = com_google_gwt_user_client_ui_RootPanel.prototype = new com_google_gwt_user_client_ui_AbsolutePanel;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 14:1, 15:1, 17:1, 18:1, 21:1, 22:1};
var com_google_gwt_user_client_ui_RootPanel_maybeDetachCommand, com_google_gwt_user_client_ui_RootPanel_rootPanels, com_google_gwt_user_client_ui_RootPanel_widgetsToDetach;
function com_google_gwt_user_client_ui_RootPanel$1_RootPanel$1__V(){
}

function com_google_gwt_user_client_ui_RootPanel$1(){
}

_ = com_google_gwt_user_client_ui_RootPanel$1_RootPanel$1__V.prototype = com_google_gwt_user_client_ui_RootPanel$1.prototype = new java_lang_Object;
_.execute__Lcom_google_gwt_user_client_ui_Widget_2V = function com_google_gwt_user_client_ui_RootPanel$1_execute__Lcom_google_gwt_user_client_ui_Widget_2V(w){
  w.isAttached__Z() && w.onDetach__V();
}
;
_.java_lang_Object_castableTypeMap$ = {};
function com_google_gwt_user_client_ui_RootPanel$2_RootPanel$2__V(){
}

function com_google_gwt_user_client_ui_RootPanel$2(){
}

_ = com_google_gwt_user_client_ui_RootPanel$2_RootPanel$2__V.prototype = com_google_gwt_user_client_ui_RootPanel$2.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {5:1, 6:1};
function com_google_gwt_user_client_ui_RootPanel$DefaultRootPanel_RootPanel$DefaultRootPanel__V(){
  com_google_gwt_user_client_ui_RootPanel_RootPanel__Lcom_google_gwt_dom_client_Element_2V.call(this, $doc.body);
}

function com_google_gwt_user_client_ui_RootPanel$DefaultRootPanel(){
}

_ = com_google_gwt_user_client_ui_RootPanel$DefaultRootPanel_RootPanel$DefaultRootPanel__V.prototype = com_google_gwt_user_client_ui_RootPanel$DefaultRootPanel.prototype = new com_google_gwt_user_client_ui_RootPanel;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 14:1, 15:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, w){
  var td, tr, com_google_gwt_user_client_ui_VerticalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_Element_2_td_0;
  tr = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_95);
  td = (com_google_gwt_user_client_ui_VerticalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_Element_2_td_0 = com_google_gwt_dom_client_DOMImplTrident_$createElement__Lcom_google_gwt_dom_client_DOMImplTrident_2Lcom_google_gwt_dom_client_Document_2Ljava_lang_String_2Lcom_google_gwt_dom_client_Element_2($doc, $intern_93) , com_google_gwt_user_client_ui_VerticalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_Element_2_td_0[$intern_94] = this$static.com_google_gwt_user_client_ui_VerticalPanel_horzAlign.com_google_gwt_user_client_ui_HasHorizontalAlignment$HorizontalAlignmentConstant_textAlignString , com_google_gwt_user_client_ui_VerticalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_Element_2_td_0.style[$intern_78] = this$static.com_google_gwt_user_client_ui_VerticalPanel_vertAlign.com_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_verticalAlignString , com_google_gwt_user_client_ui_VerticalPanel_$createAlignedTd__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_Element_2_td_0);
  tr.appendChild(td);
  this$static.com_google_gwt_user_client_ui_CellPanel_body.appendChild(tr);
  com_google_gwt_user_client_ui_Widget_$removeFromParent__Lcom_google_gwt_user_client_ui_Widget_2V(w);
  com_google_gwt_user_client_ui_WidgetCollection_$add__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static.com_google_gwt_user_client_ui_ComplexPanel_children, w);
  td.appendChild(w.com_google_gwt_user_client_ui_UIObject_element);
  com_google_gwt_user_client_ui_Widget_$setParent__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_Widget_2V(w, this$static);
}

function com_google_gwt_user_client_ui_VerticalPanel_VerticalPanel__V(){
  com_google_gwt_user_client_ui_CellPanel_CellPanel__V.call(this);
  this.com_google_gwt_user_client_ui_VerticalPanel_horzAlign = (com_google_gwt_user_client_ui_HasHorizontalAlignment_$clinit__V() , com_google_gwt_user_client_ui_HasHorizontalAlignment_ALIGN_1DEFAULT);
  this.com_google_gwt_user_client_ui_VerticalPanel_vertAlign = (com_google_gwt_user_client_ui_HasVerticalAlignment_$clinit__V() , com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1TOP);
  this.com_google_gwt_user_client_ui_CellPanel_table[$intern_96] = $intern_97;
  this.com_google_gwt_user_client_ui_CellPanel_table[$intern_98] = $intern_97;
}

function com_google_gwt_user_client_ui_VerticalPanel(){
}

_ = com_google_gwt_user_client_ui_VerticalPanel_VerticalPanel__V.prototype = com_google_gwt_user_client_ui_VerticalPanel.prototype = new com_google_gwt_user_client_ui_CellPanel;
_.remove__Lcom_google_gwt_user_client_ui_Widget_2Z = function com_google_gwt_user_client_ui_VerticalPanel_remove__Lcom_google_gwt_user_client_ui_Widget_2Z(w){
  var removed, td, com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0;
  td = (com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = w.com_google_gwt_user_client_ui_UIObject_element.parentNode , (!com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 || com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0.nodeType != 1) && (com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0 = null) , com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2_parent_0);
  removed = com_google_gwt_user_client_ui_ComplexPanel_$remove__Lcom_google_gwt_user_client_ui_ComplexPanel_2Lcom_google_gwt_user_client_ui_Widget_2Z(this, w);
  removed && this.com_google_gwt_user_client_ui_CellPanel_body.removeChild(com_google_gwt_dom_client_DOMImpl_$getParentElement__Lcom_google_gwt_dom_client_DOMImpl_2Lcom_google_gwt_dom_client_Node_2Lcom_google_gwt_dom_client_Element_2(td));
  return removed;
}
;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 15:1, 17:1, 18:1, 21:1, 22:1};
function com_google_gwt_user_client_ui_WidgetCollection_$add__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, w){
  com_google_gwt_user_client_ui_WidgetCollection_$insert__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2IV(this$static, w, this$static.com_google_gwt_user_client_ui_WidgetCollection_size);
}

function com_google_gwt_user_client_ui_WidgetCollection_$indexOf__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2I(this$static, w){
  var i;
  for (i = 0; i < this$static.com_google_gwt_user_client_ui_WidgetCollection_size; ++i) {
    if (this$static.com_google_gwt_user_client_ui_WidgetCollection_array[i] == w) {
      return i;
    }
  }
  return -1;
}

function com_google_gwt_user_client_ui_WidgetCollection_$insert__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2IV(this$static, w, beforeIndex){
  var i, newArray;
  if (beforeIndex < 0 || beforeIndex > this$static.com_google_gwt_user_client_ui_WidgetCollection_size) {
    throw new java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V;
  }
  if (this$static.com_google_gwt_user_client_ui_WidgetCollection_size == this$static.com_google_gwt_user_client_ui_WidgetCollection_array.length) {
    newArray = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Lcom_1google_1gwt_1user_1client_1ui_1Widget_12_1classLit, {23:1}, 13, this$static.com_google_gwt_user_client_ui_WidgetCollection_array.length * 2, 0);
    for (i = 0; i < this$static.com_google_gwt_user_client_ui_WidgetCollection_array.length; ++i) {
      com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(newArray, i, this$static.com_google_gwt_user_client_ui_WidgetCollection_array[i]);
    }
    this$static.com_google_gwt_user_client_ui_WidgetCollection_array = newArray;
  }
  ++this$static.com_google_gwt_user_client_ui_WidgetCollection_size;
  for (i = this$static.com_google_gwt_user_client_ui_WidgetCollection_size - 1; i > beforeIndex; --i) {
    com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_user_client_ui_WidgetCollection_array, i, this$static.com_google_gwt_user_client_ui_WidgetCollection_array[i - 1]);
  }
  com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_user_client_ui_WidgetCollection_array, beforeIndex, w);
}

function com_google_gwt_user_client_ui_WidgetCollection_$remove__Lcom_google_gwt_user_client_ui_WidgetCollection_2IV(this$static, index){
  var i;
  if (index < 0 || index >= this$static.com_google_gwt_user_client_ui_WidgetCollection_size) {
    throw new java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V;
  }
  --this$static.com_google_gwt_user_client_ui_WidgetCollection_size;
  for (i = index; i < this$static.com_google_gwt_user_client_ui_WidgetCollection_size; ++i) {
    com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_user_client_ui_WidgetCollection_array, i, this$static.com_google_gwt_user_client_ui_WidgetCollection_array[i + 1]);
  }
  com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this$static.com_google_gwt_user_client_ui_WidgetCollection_array, this$static.com_google_gwt_user_client_ui_WidgetCollection_size, null);
}

function com_google_gwt_user_client_ui_WidgetCollection_$remove__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2V(this$static, w){
  var index;
  index = com_google_gwt_user_client_ui_WidgetCollection_$indexOf__Lcom_google_gwt_user_client_ui_WidgetCollection_2Lcom_google_gwt_user_client_ui_Widget_2I(this$static, w);
  if (index == -1) {
    throw new java_util_NoSuchElementException_NoSuchElementException__V;
  }
  com_google_gwt_user_client_ui_WidgetCollection_$remove__Lcom_google_gwt_user_client_ui_WidgetCollection_2IV(this$static, index);
}

function com_google_gwt_user_client_ui_WidgetCollection_WidgetCollection__Lcom_google_gwt_user_client_ui_HasWidgets_2V(){
  this.com_google_gwt_user_client_ui_WidgetCollection_array = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Lcom_1google_1gwt_1user_1client_1ui_1Widget_12_1classLit, {23:1}, 13, 4, 0);
}

function com_google_gwt_user_client_ui_WidgetCollection(){
}

_ = com_google_gwt_user_client_ui_WidgetCollection_WidgetCollection__Lcom_google_gwt_user_client_ui_HasWidgets_2V.prototype = com_google_gwt_user_client_ui_WidgetCollection.prototype = new java_lang_Object;
_.iterator__Ljava_util_Iterator_2 = function com_google_gwt_user_client_ui_WidgetCollection_iterator__Ljava_util_Iterator_2(){
  return new com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_WidgetCollection$WidgetIterator__Lcom_google_gwt_user_client_ui_WidgetCollection_2V(this);
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_user_client_ui_WidgetCollection_array = null;
_.com_google_gwt_user_client_ui_WidgetCollection_size = 0;
function com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_$next__Lcom_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_2Lcom_google_gwt_user_client_ui_Widget_2(this$static){
  if (this$static.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_index >= this$static.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_this$0.com_google_gwt_user_client_ui_WidgetCollection_size) {
    throw new java_util_NoSuchElementException_NoSuchElementException__V;
  }
  return this$static.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_this$0.com_google_gwt_user_client_ui_WidgetCollection_array[++this$static.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_index];
}

function com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_WidgetCollection$WidgetIterator__Lcom_google_gwt_user_client_ui_WidgetCollection_2V(this$0){
  this.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_this$0 = this$0;
}

function com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator(){
}

_ = com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_WidgetCollection$WidgetIterator__Lcom_google_gwt_user_client_ui_WidgetCollection_2V.prototype = com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator.prototype = new java_lang_Object;
_.hasNext__Z = function com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_hasNext__Z(){
  return this.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_index < this.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_this$0.com_google_gwt_user_client_ui_WidgetCollection_size - 1;
}
;
_.next__Ljava_lang_Object_2 = function com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_next__Ljava_lang_Object_2(){
  return com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_$next__Lcom_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_2Lcom_google_gwt_user_client_ui_Widget_2(this);
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_index = -1;
_.com_google_gwt_user_client_ui_WidgetCollection$WidgetIterator_this$0 = null;
function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget(){
}

_ = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget.prototype = new com_google_gwt_gadgets_client_Gadget;
_.java_lang_Object_castableTypeMap$ = {};
function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadgetGadgetImpl_DeploymentGadgetGadgetImpl__V(){
  var eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_$init__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_2Lcom_google_gwt_gadgets_client_UserPreferences_2V_dw_0;
  eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_$init__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_2Lcom_google_gwt_gadgets_client_UserPreferences_2V_dw_0 = new eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_DeploymentWidget__V;
  com_google_gwt_user_client_ui_AbsolutePanel_$add__Lcom_google_gwt_user_client_ui_AbsolutePanel_2Lcom_google_gwt_user_client_ui_Widget_2V((com_google_gwt_user_client_ui_RootPanel_$clinit__V() , com_google_gwt_user_client_ui_RootPanel_get__Ljava_lang_String_2Lcom_google_gwt_user_client_ui_RootPanel_2()), eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_$init__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget_2Lcom_google_gwt_gadgets_client_UserPreferences_2V_dw_0);
}

function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadgetGadgetImpl(){
}

_ = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadgetGadgetImpl_DeploymentGadgetGadgetImpl__V.prototype = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadgetGadgetImpl.prototype = new eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentGadget;
_.java_lang_Object_castableTypeMap$ = {};
function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_DeploymentWidget__V(){
  var deployButton, fileUpload, horizontalPanel_1, lblApplicationTechnology, lblPleaseSelectYour, lblPleaseSelectYour_1, rbJava, rbPhp, rbPython, selectPaaScomboBox, verticalPanel, verticalPanel_1, verticalPanel_2;
  verticalPanel = new com_google_gwt_user_client_ui_VerticalPanel_VerticalPanel__V;
  com_google_gwt_user_client_ui_Composite_$initWidget__Lcom_google_gwt_user_client_ui_Composite_2Lcom_google_gwt_user_client_ui_Widget_2V(this, verticalPanel);
  verticalPanel.com_google_gwt_user_client_ui_UIObject_element.style[$intern_105] = $intern_106;
  verticalPanel.com_google_gwt_user_client_ui_UIObject_element.style[$intern_107] = $intern_108;
  lblPleaseSelectYour = new com_google_gwt_user_client_ui_Label_Label__Ljava_lang_String_2V($intern_109);
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel, lblPleaseSelectYour);
  com_google_gwt_user_client_ui_CellPanel_$setCellVerticalAlignment__Lcom_google_gwt_user_client_ui_CellPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_2V(verticalPanel, lblPleaseSelectYour, (com_google_gwt_user_client_ui_HasVerticalAlignment_$clinit__V() , com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1MIDDLE));
  fileUpload = new com_google_gwt_user_client_ui_FileUpload_FileUpload__V;
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel, fileUpload);
  fileUpload.com_google_gwt_user_client_ui_UIObject_element.style[$intern_105] = $intern_110;
  horizontalPanel_1 = new com_google_gwt_user_client_ui_HorizontalPanel_HorizontalPanel__V;
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel, horizontalPanel_1);
  horizontalPanel_1.com_google_gwt_user_client_ui_UIObject_element.style[$intern_105] = $intern_111;
  horizontalPanel_1.com_google_gwt_user_client_ui_UIObject_element.style[$intern_107] = $intern_112;
  verticalPanel_1 = new com_google_gwt_user_client_ui_VerticalPanel_VerticalPanel__V;
  verticalPanel_1.com_google_gwt_user_client_ui_UIObject_element.style[$intern_105] = $intern_113;
  verticalPanel_1.com_google_gwt_user_client_ui_UIObject_element.style[$intern_107] = $intern_112;
  com_google_gwt_user_client_ui_HorizontalPanel_$add__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(horizontalPanel_1, verticalPanel_1);
  lblApplicationTechnology = new com_google_gwt_user_client_ui_Label_Label__Ljava_lang_String_2V($intern_114);
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_1, lblApplicationTechnology);
  rbJava = new com_google_gwt_user_client_ui_RadioButton_RadioButton__Ljava_lang_String_2Ljava_lang_String_2V($intern_115);
  com_google_gwt_user_client_ui_CheckBox_$setValue__Lcom_google_gwt_user_client_ui_CheckBox_2Ljava_lang_Boolean_2ZV(rbJava, (java_lang_Boolean_$clinit__V() , java_lang_Boolean_$clinit__V() , java_lang_Boolean_TRUE));
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_1, rbJava);
  rbPhp = new com_google_gwt_user_client_ui_RadioButton_RadioButton__Ljava_lang_String_2Ljava_lang_String_2V($intern_116);
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_1, rbPhp);
  rbPython = new com_google_gwt_user_client_ui_RadioButton_RadioButton__Ljava_lang_String_2Ljava_lang_String_2V($intern_117);
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_1, rbPython);
  verticalPanel_2 = new com_google_gwt_user_client_ui_VerticalPanel_VerticalPanel__V;
  com_google_gwt_user_client_ui_HorizontalPanel_$add__Lcom_google_gwt_user_client_ui_HorizontalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(horizontalPanel_1, verticalPanel_2);
  lblPleaseSelectYour_1 = new com_google_gwt_user_client_ui_Label_Label__Ljava_lang_String_2V($intern_118);
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_2, lblPleaseSelectYour_1);
  selectPaaScomboBox = new com_google_gwt_user_client_ui_ListBox_ListBox__V;
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel_2, selectPaaScomboBox);
  com_google_gwt_user_client_ui_ListBox_$insertItem__Lcom_google_gwt_user_client_ui_ListBox_2Ljava_lang_String_2Ljava_lang_String_2IV(selectPaaScomboBox, $intern_119, $intern_119);
  com_google_gwt_user_client_ui_ListBox_$insertItem__Lcom_google_gwt_user_client_ui_ListBox_2Ljava_lang_String_2Ljava_lang_String_2IV(selectPaaScomboBox, $intern_120, $intern_120);
  com_google_gwt_user_client_ui_ListBox_$insertItem__Lcom_google_gwt_user_client_ui_ListBox_2Ljava_lang_String_2Ljava_lang_String_2IV(selectPaaScomboBox, $intern_121, $intern_121);
  com_google_gwt_user_client_ui_CellPanel_$setCellVerticalAlignment__Lcom_google_gwt_user_client_ui_CellPanel_2Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_user_client_ui_HasVerticalAlignment$VerticalAlignmentConstant_2V(horizontalPanel_1, selectPaaScomboBox, com_google_gwt_user_client_ui_HasVerticalAlignment_ALIGN_1MIDDLE);
  deployButton = new com_google_gwt_user_client_ui_Button_Button__Ljava_lang_String_2V;
  com_google_gwt_user_client_ui_Widget_$addDomHandler__Lcom_google_gwt_user_client_ui_Widget_2Lcom_google_gwt_event_shared_EventHandler_2Lcom_google_gwt_event_dom_client_DomEvent$Type_2Lcom_google_gwt_event_shared_HandlerRegistration_2(deployButton, new eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_DeploymentWidget$1__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_2V(fileUpload, selectPaaScomboBox, rbJava, rbPhp, rbPython), (com_google_gwt_event_dom_client_ClickEvent_$clinit__V() , com_google_gwt_event_dom_client_ClickEvent_$clinit__V() , com_google_gwt_event_dom_client_ClickEvent_TYPE));
  deployButton.com_google_gwt_user_client_ui_UIObject_element.innerText = $intern_122;
  com_google_gwt_user_client_ui_VerticalPanel_$add__Lcom_google_gwt_user_client_ui_VerticalPanel_2Lcom_google_gwt_user_client_ui_Widget_2V(verticalPanel, deployButton);
}

function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget(){
}

_ = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_DeploymentWidget__V.prototype = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget.prototype = new com_google_gwt_user_client_ui_Composite;
_.java_lang_Object_castableTypeMap$ = {12:1, 13:1, 17:1, 18:1, 21:1, 22:1};
function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_$onClick__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_2Lcom_google_gwt_event_dom_client_ClickEvent_2V(this$static){
  var applicationTech, confirmed, deploymentFile, paasProvider;
  deploymentFile = this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$fileUpload.com_google_gwt_user_client_ui_UIObject_element.value;
  paasProvider = com_google_gwt_user_client_ui_ListBox_$getItemText__Lcom_google_gwt_user_client_ui_ListBox_2ILjava_lang_String_2(this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$selectPaaScomboBox, this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$selectPaaScomboBox.com_google_gwt_user_client_ui_UIObject_element.selectedIndex);
  applicationTech = null;
  com_google_gwt_user_client_ui_CheckBox_$isChecked__Lcom_google_gwt_user_client_ui_CheckBox_2Z(this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbJava)?(applicationTech = $intern_115):com_google_gwt_user_client_ui_CheckBox_$isChecked__Lcom_google_gwt_user_client_ui_CheckBox_2Z(this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPhp)?(applicationTech = $intern_116):com_google_gwt_user_client_ui_CheckBox_$isChecked__Lcom_google_gwt_user_client_ui_CheckBox_2Z(this$static.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPython) && (applicationTech = $intern_117);
  confirmed = $wnd.confirm($intern_123 + deploymentFile + $intern_124 + paasProvider + $intern_125 + applicationTech + $intern_126);
  confirmed && (gadgets.pubsub.publish($intern_127, java_lang_String_$substring__Ljava_lang_String_2ILjava_lang_String_2(deploymentFile, deploymentFile.lastIndexOf($intern_128) + 1)) , undefined);
}

function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_DeploymentWidget$1__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_2V(val$fileUpload, val$selectPaaScomboBox, val$rbJava, val$rbPhp, val$rbPython){
  this.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$fileUpload = val$fileUpload;
  this.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$selectPaaScomboBox = val$selectPaaScomboBox;
  this.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbJava = val$rbJava;
  this.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPhp = val$rbPhp;
  this.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPython = val$rbPython;
}

function eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1(){
}

_ = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_DeploymentWidget$1__Leu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget_2V.prototype = eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {3:1, 6:1};
_.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$fileUpload = null;
_.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbJava = null;
_.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPhp = null;
_.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$rbPython = null;
_.eu_cloud4soa_ui_samples_google_gadgets_client_DeploymentWidget$1_val$selectPaaScomboBox = null;
function java_lang_ArrayStoreException_ArrayStoreException__V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_ArrayStoreException(){
}

_ = java_lang_ArrayStoreException_ArrayStoreException__V.prototype = java_lang_ArrayStoreException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_lang_Boolean_$clinit__V(){
  java_lang_Boolean_$clinit__V = nullMethod;
  java_lang_Boolean_FALSE = new java_lang_Boolean_Boolean__ZV(false);
  java_lang_Boolean_TRUE = new java_lang_Boolean_Boolean__ZV(true);
}

function java_lang_Boolean_Boolean__ZV(value){
  this.java_lang_Boolean_value = value;
}

function java_lang_Boolean(){
}

_ = java_lang_Boolean_Boolean__ZV.prototype = java_lang_Boolean.prototype = new java_lang_Object;
_.equals__Ljava_lang_Object_2Z$ = function java_lang_Boolean_equals__Ljava_lang_Object_2Z(o){
  return o != null && o.java_lang_Object_castableTypeMap$ && !!o.java_lang_Object_castableTypeMap$[16] && com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(o, 16).java_lang_Boolean_value == this.java_lang_Boolean_value;
}
;
_.hashCode__I$ = function java_lang_Boolean_hashCode__I(){
  return this.java_lang_Boolean_value?1231:1237;
}
;
_.java_lang_Object_castableTypeMap$ = {16:1, 23:1, 24:1};
_.java_lang_Boolean_value = false;
var java_lang_Boolean_FALSE, java_lang_Boolean_TRUE;
function java_lang_Class_Class__V(){
}

function java_lang_Class(){
}

_ = java_lang_Class_Class__V.prototype = java_lang_Class.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {};
function java_lang_ClassCastException_ClassCastException__V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_ClassCastException(){
}

_ = java_lang_ClassCastException_ClassCastException__V.prototype = java_lang_ClassCastException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V(s){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_IllegalStateException(){
}

_ = java_lang_IllegalStateException_IllegalStateException__Ljava_lang_String_2V.prototype = java_lang_IllegalStateException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__Ljava_lang_String_2V(message){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_IndexOutOfBoundsException(){
}

_ = java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__Ljava_lang_String_2V.prototype = java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V.prototype = java_lang_IndexOutOfBoundsException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_lang_NullPointerException_NullPointerException__V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_NullPointerException_NullPointerException__Ljava_lang_String_2V(message){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_NullPointerException(){
}

_ = java_lang_NullPointerException_NullPointerException__Ljava_lang_String_2V.prototype = java_lang_NullPointerException_NullPointerException__V.prototype = java_lang_NullPointerException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_lang_StackTraceElement_StackTraceElement__Ljava_lang_String_2Ljava_lang_String_2Ljava_lang_String_2IV(methodName){
}

function java_lang_StackTraceElement(){
}

_ = java_lang_StackTraceElement_StackTraceElement__Ljava_lang_String_2Ljava_lang_String_2Ljava_lang_String_2IV.prototype = java_lang_StackTraceElement.prototype = new java_lang_Object;
_.java_lang_Object_castableTypeMap$ = {23:1, 26:1};
function java_lang_String_$equalsIgnoreCase__Ljava_lang_String_2Ljava_lang_String_2Z(this$static, other){
  if (other == null)
    return false;
  return this$static == other || this$static.toLowerCase() == other.toLowerCase();
}

function java_lang_String_$substring__Ljava_lang_String_2ILjava_lang_String_2(this$static, beginIndex){
  return this$static.substr(beginIndex, this$static.length - beginIndex);
}

function java_lang_String_$trim__Ljava_lang_String_2Ljava_lang_String_2(this$static){
  if (this$static.length == 0 || this$static[0] > $intern_129 && this$static[this$static.length - 1] > $intern_129) {
    return this$static;
  }
  var r1 = this$static.replace(/^(\s*)/, $intern_0);
  var r2 = r1.replace(/\s*$/, $intern_0);
  return r2;
}

_ = String.prototype;
_.equals__Ljava_lang_Object_2Z$ = function java_lang_String_equals__Ljava_lang_Object_2Z(other){
  if (!(other != null && other.java_lang_Object_castableTypeMap$ && !!other.java_lang_Object_castableTypeMap$[1])) {
    return false;
  }
  return String(this) == other;
}
;
_.hashCode__I$ = function java_lang_String_hashCode__I(){
  return java_lang_String$HashCache_getHashCode__Ljava_lang_String_2I(this);
}
;
_.java_lang_Object_castableTypeMap$ = {1:1, 23:1, 24:1};
function java_lang_String$HashCache_$clinit__V(){
  java_lang_String$HashCache_$clinit__V = nullMethod;
  java_lang_String$HashCache_back = {};
  java_lang_String$HashCache_front = {};
}

function java_lang_String$HashCache_compute__Ljava_lang_String_2I(str){
  var hashCode, i, n, nBatch;
  hashCode = 0;
  n = str.length;
  nBatch = n - 4;
  i = 0;
  while (i < nBatch) {
    hashCode = str.charCodeAt(i + 3) + 31 * (str.charCodeAt(i + 2) + 31 * (str.charCodeAt(i + 1) + 31 * (str.charCodeAt(i) + 31 * hashCode))) | 0;
    i += 4;
  }
  while (i < n) {
    hashCode = hashCode * 31 + str.charCodeAt(i++);
  }
  return hashCode | 0;
}

function java_lang_String$HashCache_getHashCode__Ljava_lang_String_2I(str){
  java_lang_String$HashCache_$clinit__V();
  var key = $intern_4 + str;
  var result = java_lang_String$HashCache_front[key];
  if (result != null) {
    return result;
  }
  result = java_lang_String$HashCache_back[key];
  result == null && (result = java_lang_String$HashCache_compute__Ljava_lang_String_2I(str));
  java_lang_String$HashCache_increment__V();
  return java_lang_String$HashCache_front[key] = result;
}

function java_lang_String$HashCache_increment__V(){
  if (java_lang_String$HashCache_count == 256) {
    java_lang_String$HashCache_back = java_lang_String$HashCache_front;
    java_lang_String$HashCache_front = {};
    java_lang_String$HashCache_count = 0;
  }
  ++java_lang_String$HashCache_count;
}

var java_lang_String$HashCache_back, java_lang_String$HashCache_count = 0, java_lang_String$HashCache_front;
function java_lang_UnsupportedOperationException_UnsupportedOperationException__Ljava_lang_String_2V(message){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_lang_UnsupportedOperationException(){
}

_ = java_lang_UnsupportedOperationException_UnsupportedOperationException__Ljava_lang_String_2V.prototype = java_lang_UnsupportedOperationException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_util_AbstractCollection_$advanceToFind__Ljava_util_AbstractCollection_2Ljava_util_Iterator_2Ljava_lang_Object_2Ljava_util_Iterator_2(iter, o){
  var t;
  while (iter.hasNext__Z()) {
    t = iter.next__Ljava_lang_Object_2();
    if (o == null?t == null:com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(o, t)) {
      return iter;
    }
  }
  return null;
}

function java_util_AbstractCollection(){
}

_ = java_util_AbstractCollection.prototype = new java_lang_Object;
_.add__Ljava_lang_Object_2Z = function java_util_AbstractCollection_add__Ljava_lang_Object_2Z(o){
  throw new java_lang_UnsupportedOperationException_UnsupportedOperationException__Ljava_lang_String_2V($intern_130);
}
;
_.contains__Ljava_lang_Object_2Z = function java_util_AbstractCollection_contains__Ljava_lang_Object_2Z(o){
  var iter;
  iter = java_util_AbstractCollection_$advanceToFind__Ljava_util_AbstractCollection_2Ljava_util_Iterator_2Ljava_lang_Object_2Ljava_util_Iterator_2(this.iterator__Ljava_util_Iterator_2(), o);
  return !!iter;
}
;
_.toArray___3Ljava_lang_Object_2_3Ljava_lang_Object_2 = function java_util_AbstractCollection_toArray___3Ljava_lang_Object_2_3Ljava_lang_Object_2(a){
  var i, it, size;
  size = this.size__I();
  a.length < size && (a = com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2(a, size));
  it = this.iterator__Ljava_util_Iterator_2();
  for (i = 0; i < size; ++i) {
    com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(a, i, it.next__Ljava_lang_Object_2());
  }
  a.length > size && com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(a, size, null);
  return a;
}
;
_.java_lang_Object_castableTypeMap$ = {};
function java_util_AbstractMap_$keySet__Ljava_util_AbstractMap_2Ljava_util_Set_2(this$static){
  var entrySet;
  entrySet = new java_util_AbstractHashMap$EntrySet_AbstractHashMap$EntrySet__Ljava_util_AbstractHashMap_2V(this$static);
  return new java_util_AbstractMap$1_AbstractMap$1__Ljava_util_AbstractMap_2V(this$static, entrySet);
}

function java_util_AbstractMap(){
}

_ = java_util_AbstractMap.prototype = new java_lang_Object;
_.equals__Ljava_lang_Object_2Z$ = function java_util_AbstractMap_equals__Ljava_lang_Object_2Z(obj){
  var entry, entry$iterator, otherKey, otherMap, otherValue;
  if (obj === this) {
    return true;
  }
  if (!(obj != null && obj.java_lang_Object_castableTypeMap$ && !!obj.java_lang_Object_castableTypeMap$[8])) {
    return false;
  }
  otherMap = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(obj, 8);
  if (this.java_util_AbstractHashMap_size != otherMap.java_util_AbstractHashMap_size) {
    return false;
  }
  for (entry$iterator = new java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V((new java_util_AbstractHashMap$EntrySet_AbstractHashMap$EntrySet__Ljava_util_AbstractHashMap_2V(otherMap)).java_util_AbstractHashMap$EntrySet_this$0); java_util_AbstractList$IteratorImpl_$hasNext__Ljava_util_AbstractList$IteratorImpl_2Z(entry$iterator.java_util_AbstractHashMap$EntrySetIterator_iter);) {
    entry = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(entry$iterator.java_util_AbstractHashMap$EntrySetIterator_iter), 27);
    otherKey = entry.getKey__Ljava_lang_Object_2();
    otherValue = entry.getValue__Ljava_lang_Object_2();
    if (!(otherKey == null?this.java_util_AbstractHashMap_nullSlotLive:otherKey != null && otherKey.java_lang_Object_castableTypeMap$ && !!otherKey.java_lang_Object_castableTypeMap$[1]?$intern_4 + com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(otherKey, 1) in this.java_util_AbstractHashMap_stringMap:java_util_AbstractHashMap_$hasHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2IZ(this, otherKey, ~~com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(otherKey)))) {
      return false;
    }
    if (!java_util_Utility_equalsWithNullCheck__Ljava_lang_Object_2Ljava_lang_Object_2Z(otherValue, otherKey == null?this.java_util_AbstractHashMap_nullSlot:otherKey != null && otherKey.java_lang_Object_castableTypeMap$ && !!otherKey.java_lang_Object_castableTypeMap$[1]?this.java_util_AbstractHashMap_stringMap[$intern_4 + com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(otherKey, 1)]:java_util_AbstractHashMap_$getHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2ILjava_lang_Object_2(this, otherKey, ~~com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(otherKey)))) {
      return false;
    }
  }
  return true;
}
;
_.hashCode__I$ = function java_util_AbstractMap_hashCode__I(){
  var entry, entry$iterator, hashCode;
  hashCode = 0;
  for (entry$iterator = new java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V((new java_util_AbstractHashMap$EntrySet_AbstractHashMap$EntrySet__Ljava_util_AbstractHashMap_2V(this)).java_util_AbstractHashMap$EntrySet_this$0); java_util_AbstractList$IteratorImpl_$hasNext__Ljava_util_AbstractList$IteratorImpl_2Z(entry$iterator.java_util_AbstractHashMap$EntrySetIterator_iter);) {
    entry = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(entry$iterator.java_util_AbstractHashMap$EntrySetIterator_iter), 27);
    hashCode += entry.hashCode__I$();
    hashCode = ~~hashCode;
  }
  return hashCode;
}
;
_.java_lang_Object_castableTypeMap$ = {8:1};
function java_util_AbstractHashMap_$addAllHashEntries__Ljava_util_AbstractHashMap_2Ljava_util_Collection_2V(this$static, dest){
  var hashCodeMap = this$static.java_util_AbstractHashMap_hashCodeMap;
  for (var hashCode in hashCodeMap) {
    var hashCodeInt = parseInt(hashCode, 10);
    if (hashCode == hashCodeInt) {
      var array = hashCodeMap[hashCodeInt];
      for (var i = 0, c = array.length; i < c; ++i) {
        dest.add__Ljava_lang_Object_2Z(array[i]);
      }
    }
  }
}

function java_util_AbstractHashMap_$addAllStringEntries__Ljava_util_AbstractHashMap_2Ljava_util_Collection_2V(this$static, dest){
  var stringMap = this$static.java_util_AbstractHashMap_stringMap;
  for (var key in stringMap) {
    if (key.charCodeAt(0) == 58) {
      var entry = new java_util_AbstractHashMap$MapEntryString_AbstractHashMap$MapEntryString__Ljava_util_AbstractHashMap_2Ljava_lang_String_2V(this$static, key.substring(1));
      dest.add__Ljava_lang_Object_2Z(entry);
    }
  }
}

function java_util_AbstractHashMap_$clearImpl__Ljava_util_AbstractHashMap_2V(this$static){
  this$static.java_util_AbstractHashMap_hashCodeMap = [];
  this$static.java_util_AbstractHashMap_stringMap = {};
  this$static.java_util_AbstractHashMap_nullSlotLive = false;
  this$static.java_util_AbstractHashMap_nullSlot = null;
  this$static.java_util_AbstractHashMap_size = 0;
}

function java_util_AbstractHashMap_$containsKey__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Z(this$static, key){
  return key == null?this$static.java_util_AbstractHashMap_nullSlotLive:key != null && key.java_lang_Object_castableTypeMap$ && !!key.java_lang_Object_castableTypeMap$[1]?java_util_AbstractHashMap_$hasStringValue__Ljava_util_AbstractHashMap_2Ljava_lang_String_2Z(this$static, com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(key, 1)):java_util_AbstractHashMap_$hasHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2IZ(this$static, key, ~~com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(key));
}

function java_util_AbstractHashMap_$get__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, key){
  return key == null?this$static.java_util_AbstractHashMap_nullSlot:key != null && key.java_lang_Object_castableTypeMap$ && !!key.java_lang_Object_castableTypeMap$[1]?this$static.java_util_AbstractHashMap_stringMap[$intern_4 + com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(key, 1)]:java_util_AbstractHashMap_$getHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, ~~com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(key));
}

function java_util_AbstractHashMap_$getHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, hashCode){
  var array = this$static.java_util_AbstractHashMap_hashCodeMap[hashCode];
  if (array) {
    for (var i = 0, c = array.length; i < c; ++i) {
      var entry = array[i];
      var entryKey = entry.getKey__Ljava_lang_Object_2();
      if (this$static.private$java_util_AbstractHashMap$equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z(key, entryKey)) {
        return entry.getValue__Ljava_lang_Object_2();
      }
    }
  }
  return null;
}

function java_util_AbstractHashMap_$hasHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2IZ(this$static, key, hashCode){
  var array = this$static.java_util_AbstractHashMap_hashCodeMap[hashCode];
  if (array) {
    for (var i = 0, c = array.length; i < c; ++i) {
      var entry = array[i];
      var entryKey = entry.getKey__Ljava_lang_Object_2();
      if (this$static.private$java_util_AbstractHashMap$equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z(key, entryKey)) {
        return true;
      }
    }
  }
  return false;
}

function java_util_AbstractHashMap_$hasStringValue__Ljava_util_AbstractHashMap_2Ljava_lang_String_2Z(this$static, key){
  return $intern_4 + key in this$static.java_util_AbstractHashMap_stringMap;
}

function java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, key, value){
  return key == null?java_util_AbstractHashMap_$putNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, value):key != null && key.java_lang_Object_castableTypeMap$ && !!key.java_lang_Object_castableTypeMap$[1]?java_util_AbstractHashMap_$putStringValue__Ljava_util_AbstractHashMap_2Ljava_lang_String_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(key, 1), value):java_util_AbstractHashMap_$putHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, value, ~~com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(key));
}

function java_util_AbstractHashMap_$putHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, value, hashCode){
  var array = this$static.java_util_AbstractHashMap_hashCodeMap[hashCode];
  if (array) {
    for (var i = 0, c = array.length; i < c; ++i) {
      var entry = array[i];
      var entryKey = entry.getKey__Ljava_lang_Object_2();
      if (this$static.private$java_util_AbstractHashMap$equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z(key, entryKey)) {
        var previous = entry.getValue__Ljava_lang_Object_2();
        entry.setValue__Ljava_lang_Object_2Ljava_lang_Object_2(value);
        return previous;
      }
    }
  }
   else {
    array = this$static.java_util_AbstractHashMap_hashCodeMap[hashCode] = [];
  }
  var entry = new java_util_MapEntryImpl_MapEntryImpl__Ljava_lang_Object_2Ljava_lang_Object_2V(key, value);
  array.push(entry);
  ++this$static.java_util_AbstractHashMap_size;
  return null;
}

function java_util_AbstractHashMap_$putNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, value){
  var result;
  result = this$static.java_util_AbstractHashMap_nullSlot;
  this$static.java_util_AbstractHashMap_nullSlot = value;
  if (!this$static.java_util_AbstractHashMap_nullSlotLive) {
    this$static.java_util_AbstractHashMap_nullSlotLive = true;
    ++this$static.java_util_AbstractHashMap_size;
  }
  return result;
}

function java_util_AbstractHashMap_$putStringValue__Ljava_util_AbstractHashMap_2Ljava_lang_String_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, key, value){
  var result, stringMap = this$static.java_util_AbstractHashMap_stringMap;
  key = $intern_4 + key;
  key in stringMap?(result = stringMap[key]):++this$static.java_util_AbstractHashMap_size;
  stringMap[key] = value;
  return result;
}

function java_util_AbstractHashMap_$remove__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static, key){
  return !key?java_util_AbstractHashMap_$removeNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2(this$static):java_util_AbstractHashMap_$removeHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, ~~(key.$H || (key.$H = ++com_google_gwt_core_client_impl_Impl_sNextHashId)));
}

function java_util_AbstractHashMap_$removeHashValue__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2ILjava_lang_Object_2(this$static, key, hashCode){
  var array = this$static.java_util_AbstractHashMap_hashCodeMap[hashCode];
  if (array) {
    for (var i = 0, c = array.length; i < c; ++i) {
      var entry = array[i];
      var entryKey = entry.getKey__Ljava_lang_Object_2();
      if (this$static.private$java_util_AbstractHashMap$equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z(key, entryKey)) {
        array.length == 1?delete this$static.java_util_AbstractHashMap_hashCodeMap[hashCode]:array.splice(i, 1);
        --this$static.java_util_AbstractHashMap_size;
        return entry.getValue__Ljava_lang_Object_2();
      }
    }
  }
  return null;
}

function java_util_AbstractHashMap_$removeNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2(this$static){
  var result;
  result = this$static.java_util_AbstractHashMap_nullSlot;
  this$static.java_util_AbstractHashMap_nullSlot = null;
  if (this$static.java_util_AbstractHashMap_nullSlotLive) {
    this$static.java_util_AbstractHashMap_nullSlotLive = false;
    --this$static.java_util_AbstractHashMap_size;
  }
  return result;
}

function java_util_AbstractHashMap(){
}

_ = java_util_AbstractHashMap.prototype = new java_util_AbstractMap;
_.private$java_util_AbstractHashMap$equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z = function java_util_AbstractHashMap_equalsBridge__Ljava_lang_Object_2Ljava_lang_Object_2Z(value1, value2){
  return (value1 == null?null:value1) === (value2 == null?null:value2) || value1 != null && com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(value1, value2);
}
;
_.java_lang_Object_castableTypeMap$ = {8:1};
_.java_util_AbstractHashMap_hashCodeMap = null;
_.java_util_AbstractHashMap_nullSlot = null;
_.java_util_AbstractHashMap_nullSlotLive = false;
_.java_util_AbstractHashMap_size = 0;
_.java_util_AbstractHashMap_stringMap = null;
function java_util_AbstractSet(){
}

_ = java_util_AbstractSet.prototype = new java_util_AbstractCollection;
_.equals__Ljava_lang_Object_2Z$ = function java_util_AbstractSet_equals__Ljava_lang_Object_2Z(o){
  var iter, other, otherItem;
  if (o === this) {
    return true;
  }
  if (!(o != null && o.java_lang_Object_castableTypeMap$ && !!o.java_lang_Object_castableTypeMap$[28])) {
    return false;
  }
  other = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(o, 28);
  if (other.size__I() != this.size__I()) {
    return false;
  }
  for (iter = other.iterator__Ljava_util_Iterator_2(); iter.hasNext__Z();) {
    otherItem = iter.next__Ljava_lang_Object_2();
    if (!this.contains__Ljava_lang_Object_2Z(otherItem)) {
      return false;
    }
  }
  return true;
}
;
_.hashCode__I$ = function java_util_AbstractSet_hashCode__I(){
  var hashCode, iter, next;
  hashCode = 0;
  for (iter = this.iterator__Ljava_util_Iterator_2(); iter.hasNext__Z();) {
    next = iter.next__Ljava_lang_Object_2();
    if (next != null) {
      hashCode += com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(next);
      hashCode = ~~hashCode;
    }
  }
  return hashCode;
}
;
_.java_lang_Object_castableTypeMap$ = {28:1};
function java_util_AbstractHashMap$EntrySet_$contains__Ljava_util_AbstractHashMap$EntrySet_2Ljava_lang_Object_2Z(this$static, o){
  var entry, key, value;
  if (o != null && o.java_lang_Object_castableTypeMap$ && !!o.java_lang_Object_castableTypeMap$[27]) {
    entry = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(o, 27);
    key = entry.getKey__Ljava_lang_Object_2();
    if (java_util_AbstractHashMap_$containsKey__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Z(this$static.java_util_AbstractHashMap$EntrySet_this$0, key)) {
      value = java_util_AbstractHashMap_$get__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static.java_util_AbstractHashMap$EntrySet_this$0, key);
      return java_util_HashMap_$equals__Ljava_util_HashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Z(entry.getValue__Ljava_lang_Object_2(), value);
    }
  }
  return false;
}

function java_util_AbstractHashMap$EntrySet_AbstractHashMap$EntrySet__Ljava_util_AbstractHashMap_2V(this$0){
  this.java_util_AbstractHashMap$EntrySet_this$0 = this$0;
}

function java_util_AbstractHashMap$EntrySet(){
}

_ = java_util_AbstractHashMap$EntrySet_AbstractHashMap$EntrySet__Ljava_util_AbstractHashMap_2V.prototype = java_util_AbstractHashMap$EntrySet.prototype = new java_util_AbstractSet;
_.contains__Ljava_lang_Object_2Z = function java_util_AbstractHashMap$EntrySet_contains__Ljava_lang_Object_2Z(o){
  return java_util_AbstractHashMap$EntrySet_$contains__Ljava_util_AbstractHashMap$EntrySet_2Ljava_lang_Object_2Z(this, o);
}
;
_.iterator__Ljava_util_Iterator_2 = function java_util_AbstractHashMap$EntrySet_iterator__Ljava_util_Iterator_2(){
  return new java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V(this.java_util_AbstractHashMap$EntrySet_this$0);
}
;
_.size__I = function java_util_AbstractHashMap$EntrySet_size__I(){
  return this.java_util_AbstractHashMap$EntrySet_this$0.java_util_AbstractHashMap_size;
}
;
_.java_lang_Object_castableTypeMap$ = {28:1};
_.java_util_AbstractHashMap$EntrySet_this$0 = null;
function java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V(this$0){
  var list;
  list = new java_util_ArrayList_ArrayList__V;
  this$0.java_util_AbstractHashMap_nullSlotLive && java_util_ArrayList_$add__Ljava_util_ArrayList_2Ljava_lang_Object_2Z(list, new java_util_AbstractHashMap$MapEntryNull_AbstractHashMap$MapEntryNull__Ljava_util_AbstractHashMap_2V(this$0));
  java_util_AbstractHashMap_$addAllStringEntries__Ljava_util_AbstractHashMap_2Ljava_util_Collection_2V(this$0, list);
  java_util_AbstractHashMap_$addAllHashEntries__Ljava_util_AbstractHashMap_2Ljava_util_Collection_2V(this$0, list);
  this.java_util_AbstractHashMap$EntrySetIterator_iter = new java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(list);
}

function java_util_AbstractHashMap$EntrySetIterator(){
}

_ = java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V.prototype = java_util_AbstractHashMap$EntrySetIterator.prototype = new java_lang_Object;
_.hasNext__Z = function java_util_AbstractHashMap$EntrySetIterator_hasNext__Z(){
  return java_util_AbstractList$IteratorImpl_$hasNext__Ljava_util_AbstractList$IteratorImpl_2Z(this.java_util_AbstractHashMap$EntrySetIterator_iter);
}
;
_.next__Ljava_lang_Object_2 = function java_util_AbstractHashMap$EntrySetIterator_next__Ljava_lang_Object_2(){
  return com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(this.java_util_AbstractHashMap$EntrySetIterator_iter), 27);
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.java_util_AbstractHashMap$EntrySetIterator_iter = null;
function java_util_AbstractMapEntry(){
}

_ = java_util_AbstractMapEntry.prototype = new java_lang_Object;
_.equals__Ljava_lang_Object_2Z$ = function java_util_AbstractMapEntry_equals__Ljava_lang_Object_2Z(other){
  var entry;
  if (other != null && other.java_lang_Object_castableTypeMap$ && !!other.java_lang_Object_castableTypeMap$[27]) {
    entry = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(other, 27);
    if (java_util_Utility_equalsWithNullCheck__Ljava_lang_Object_2Ljava_lang_Object_2Z(this.getKey__Ljava_lang_Object_2(), entry.getKey__Ljava_lang_Object_2()) && java_util_Utility_equalsWithNullCheck__Ljava_lang_Object_2Ljava_lang_Object_2Z(this.getValue__Ljava_lang_Object_2(), entry.getValue__Ljava_lang_Object_2())) {
      return true;
    }
  }
  return false;
}
;
_.hashCode__I$ = function java_util_AbstractMapEntry_hashCode__I(){
  var keyHash, valueHash;
  keyHash = 0;
  valueHash = 0;
  this.getKey__Ljava_lang_Object_2() != null && (keyHash = com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(this.getKey__Ljava_lang_Object_2()));
  this.getValue__Ljava_lang_Object_2() != null && (valueHash = com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(this.getValue__Ljava_lang_Object_2()));
  return keyHash ^ valueHash;
}
;
_.java_lang_Object_castableTypeMap$ = {27:1};
function java_util_AbstractHashMap$MapEntryNull_AbstractHashMap$MapEntryNull__Ljava_util_AbstractHashMap_2V(this$0){
  this.java_util_AbstractHashMap$MapEntryNull_this$0 = this$0;
}

function java_util_AbstractHashMap$MapEntryNull(){
}

_ = java_util_AbstractHashMap$MapEntryNull_AbstractHashMap$MapEntryNull__Ljava_util_AbstractHashMap_2V.prototype = java_util_AbstractHashMap$MapEntryNull.prototype = new java_util_AbstractMapEntry;
_.getKey__Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryNull_getKey__Ljava_lang_Object_2(){
  return null;
}
;
_.getValue__Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryNull_getValue__Ljava_lang_Object_2(){
  return this.java_util_AbstractHashMap$MapEntryNull_this$0.java_util_AbstractHashMap_nullSlot;
}
;
_.setValue__Ljava_lang_Object_2Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryNull_setValue__Ljava_lang_Object_2Ljava_lang_Object_2(object){
  return java_util_AbstractHashMap_$putNullSlot__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2(this.java_util_AbstractHashMap$MapEntryNull_this$0, object);
}
;
_.java_lang_Object_castableTypeMap$ = {27:1};
_.java_util_AbstractHashMap$MapEntryNull_this$0 = null;
function java_util_AbstractHashMap$MapEntryString_AbstractHashMap$MapEntryString__Ljava_util_AbstractHashMap_2Ljava_lang_String_2V(this$0, key){
  this.java_util_AbstractHashMap$MapEntryString_this$0 = this$0;
  this.java_util_AbstractHashMap$MapEntryString_key = key;
}

function java_util_AbstractHashMap$MapEntryString(){
}

_ = java_util_AbstractHashMap$MapEntryString_AbstractHashMap$MapEntryString__Ljava_util_AbstractHashMap_2Ljava_lang_String_2V.prototype = java_util_AbstractHashMap$MapEntryString.prototype = new java_util_AbstractMapEntry;
_.getKey__Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryString_getKey__Ljava_lang_Object_2(){
  return this.java_util_AbstractHashMap$MapEntryString_key;
}
;
_.getValue__Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryString_getValue__Ljava_lang_Object_2(){
  return this.java_util_AbstractHashMap$MapEntryString_this$0.java_util_AbstractHashMap_stringMap[$intern_4 + this.java_util_AbstractHashMap$MapEntryString_key];
}
;
_.setValue__Ljava_lang_Object_2Ljava_lang_Object_2 = function java_util_AbstractHashMap$MapEntryString_setValue__Ljava_lang_Object_2Ljava_lang_Object_2(object){
  return java_util_AbstractHashMap_$putStringValue__Ljava_util_AbstractHashMap_2Ljava_lang_String_2Ljava_lang_Object_2Ljava_lang_Object_2(this.java_util_AbstractHashMap$MapEntryString_this$0, this.java_util_AbstractHashMap$MapEntryString_key, object);
}
;
_.java_lang_Object_castableTypeMap$ = {27:1};
_.java_util_AbstractHashMap$MapEntryString_key = null;
_.java_util_AbstractHashMap$MapEntryString_this$0 = null;
function java_util_AbstractList_checkIndex__IIV(index, size){
  (index < 0 || index >= size) && java_util_AbstractList_indexOutOfBounds__IIV(index, size);
}

function java_util_AbstractList_indexOutOfBounds__IIV(index, size){
  throw new java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__Ljava_lang_String_2V($intern_131 + index + $intern_132 + size);
}

function java_util_AbstractList(){
}

_ = java_util_AbstractList.prototype = new java_util_AbstractCollection;
_.add__Ljava_lang_Object_2Z = function java_util_AbstractList_add__Ljava_lang_Object_2Z(obj){
  this.add__ILjava_lang_Object_2V(this.size__I(), obj);
  return true;
}
;
_.add__ILjava_lang_Object_2V = function java_util_AbstractList_add__ILjava_lang_Object_2V(index, element){
  throw new java_lang_UnsupportedOperationException_UnsupportedOperationException__Ljava_lang_String_2V($intern_133);
}
;
_.equals__Ljava_lang_Object_2Z$ = function java_util_AbstractList_equals__Ljava_lang_Object_2Z(o){
  var elem, elemOther, iter, iterOther, other;
  if (o === this) {
    return true;
  }
  if (!(o != null && o.java_lang_Object_castableTypeMap$ && !!o.java_lang_Object_castableTypeMap$[9])) {
    return false;
  }
  other = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(o, 9);
  if (this.size__I() != other.size__I()) {
    return false;
  }
  iter = new java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(this);
  iterOther = other.iterator__Ljava_util_Iterator_2();
  while (iter.java_util_AbstractList$IteratorImpl_i < iter.java_util_AbstractList$IteratorImpl_this$0.size__I()) {
    elem = java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(iter);
    elemOther = java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(iterOther);
    if (!(elem == null?elemOther == null:com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(elem, elemOther))) {
      return false;
    }
  }
  return true;
}
;
_.hashCode__I$ = function java_util_AbstractList_hashCode__I(){
  var iter, k, obj;
  k = 1;
  iter = new java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(this);
  while (iter.java_util_AbstractList$IteratorImpl_i < iter.java_util_AbstractList$IteratorImpl_this$0.size__I()) {
    obj = java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(iter);
    k = 31 * k + (obj == null?0:com_google_gwt_core_client_JavaScriptObject_hashCode_1_1devirtual$__Ljava_lang_Object_2I(obj));
    k = ~~k;
  }
  return k;
}
;
_.iterator__Ljava_util_Iterator_2 = function java_util_AbstractList_iterator__Ljava_util_Iterator_2(){
  return new java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(this);
}
;
_.listIterator__Ljava_util_ListIterator_2 = function java_util_AbstractList_listIterator__Ljava_util_ListIterator_2(){
  return new java_util_AbstractList$ListIteratorImpl_AbstractList$ListIteratorImpl__Ljava_util_AbstractList_2IV(this, 0);
}
;
_.listIterator__ILjava_util_ListIterator_2 = function java_util_AbstractList_listIterator__ILjava_util_ListIterator_2(from){
  return new java_util_AbstractList$ListIteratorImpl_AbstractList$ListIteratorImpl__Ljava_util_AbstractList_2IV(this, from);
}
;
_.java_lang_Object_castableTypeMap$ = {9:1};
function java_util_AbstractList$IteratorImpl_$hasNext__Ljava_util_AbstractList$IteratorImpl_2Z(this$static){
  return this$static.java_util_AbstractList$IteratorImpl_i < this$static.java_util_AbstractList$IteratorImpl_this$0.size__I();
}

function java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(this$static){
  if (this$static.java_util_AbstractList$IteratorImpl_i >= this$static.java_util_AbstractList$IteratorImpl_this$0.size__I()) {
    throw new java_util_NoSuchElementException_NoSuchElementException__V;
  }
  return this$static.java_util_AbstractList$IteratorImpl_this$0.get__ILjava_lang_Object_2(this$static.java_util_AbstractList$IteratorImpl_i++);
}

function java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V(this$0){
  this.java_util_AbstractList$IteratorImpl_this$0 = this$0;
}

function java_util_AbstractList$IteratorImpl(){
}

_ = java_util_AbstractList$IteratorImpl_AbstractList$IteratorImpl__Ljava_util_AbstractList_2V.prototype = java_util_AbstractList$IteratorImpl.prototype = new java_lang_Object;
_.hasNext__Z = function java_util_AbstractList$IteratorImpl_hasNext__Z(){
  return this.java_util_AbstractList$IteratorImpl_i < this.java_util_AbstractList$IteratorImpl_this$0.size__I();
}
;
_.next__Ljava_lang_Object_2 = function java_util_AbstractList$IteratorImpl_next__Ljava_lang_Object_2(){
  return java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(this);
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.java_util_AbstractList$IteratorImpl_i = 0;
_.java_util_AbstractList$IteratorImpl_this$0 = null;
function java_util_AbstractList$ListIteratorImpl_$previous__Ljava_util_AbstractList$ListIteratorImpl_2Ljava_lang_Object_2(this$static){
  if (this$static.java_util_AbstractList$IteratorImpl_i <= 0) {
    throw new java_util_NoSuchElementException_NoSuchElementException__V;
  }
  return this$static.java_util_AbstractList$ListIteratorImpl_this$0.get__ILjava_lang_Object_2(--this$static.java_util_AbstractList$IteratorImpl_i);
}

function java_util_AbstractList$ListIteratorImpl_AbstractList$ListIteratorImpl__Ljava_util_AbstractList_2IV(this$0, start){
  var size;
  this.java_util_AbstractList$ListIteratorImpl_this$0 = this$0;
  this.java_util_AbstractList$IteratorImpl_this$0 = this$0;
  size = this$0.size__I();
  (start < 0 || start > size) && java_util_AbstractList_indexOutOfBounds__IIV(start, size);
  this.java_util_AbstractList$IteratorImpl_i = start;
}

function java_util_AbstractList$ListIteratorImpl(){
}

_ = java_util_AbstractList$ListIteratorImpl_AbstractList$ListIteratorImpl__Ljava_util_AbstractList_2IV.prototype = java_util_AbstractList$ListIteratorImpl.prototype = new java_util_AbstractList$IteratorImpl;
_.java_lang_Object_castableTypeMap$ = {};
_.java_util_AbstractList$ListIteratorImpl_this$0 = null;
function java_util_AbstractMap$1_AbstractMap$1__Ljava_util_AbstractMap_2V(this$0, val$entrySet){
  this.java_util_AbstractMap$1_this$0 = this$0;
  this.java_util_AbstractMap$1_val$entrySet = val$entrySet;
}

function java_util_AbstractMap$1(){
}

_ = java_util_AbstractMap$1_AbstractMap$1__Ljava_util_AbstractMap_2V.prototype = java_util_AbstractMap$1.prototype = new java_util_AbstractSet;
_.contains__Ljava_lang_Object_2Z = function java_util_AbstractMap$1_contains__Ljava_lang_Object_2Z(key){
  return java_util_AbstractHashMap_$containsKey__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Z(this.java_util_AbstractMap$1_this$0, key);
}
;
_.iterator__Ljava_util_Iterator_2 = function java_util_AbstractMap$1_iterator__Ljava_util_Iterator_2(){
  var java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0;
  return java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0 = new java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V(this.java_util_AbstractMap$1_val$entrySet.java_util_AbstractHashMap$EntrySet_this$0) , new java_util_AbstractMap$1$1_AbstractMap$1$1__Ljava_util_AbstractMap$1_2V(java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0);
}
;
_.size__I = function java_util_AbstractMap$1_size__I(){
  return this.java_util_AbstractMap$1_val$entrySet.java_util_AbstractHashMap$EntrySet_this$0.java_util_AbstractHashMap_size;
}
;
_.java_lang_Object_castableTypeMap$ = {28:1};
_.java_util_AbstractMap$1_this$0 = null;
_.java_util_AbstractMap$1_val$entrySet = null;
function java_util_AbstractMap$1$1_AbstractMap$1$1__Ljava_util_AbstractMap$1_2V(val$outerIter){
  this.java_util_AbstractMap$1$1_val$outerIter = val$outerIter;
}

function java_util_AbstractMap$1$1(){
}

_ = java_util_AbstractMap$1$1_AbstractMap$1$1__Ljava_util_AbstractMap$1_2V.prototype = java_util_AbstractMap$1$1.prototype = new java_lang_Object;
_.hasNext__Z = function java_util_AbstractMap$1$1_hasNext__Z(){
  return java_util_AbstractList$IteratorImpl_$hasNext__Ljava_util_AbstractList$IteratorImpl_2Z(this.java_util_AbstractMap$1$1_val$outerIter.java_util_AbstractHashMap$EntrySetIterator_iter);
}
;
_.next__Ljava_lang_Object_2 = function java_util_AbstractMap$1$1_next__Ljava_lang_Object_2(){
  var entry;
  entry = com_google_gwt_lang_Cast_dynamicCast__Ljava_lang_Object_2ILjava_lang_Object_2(java_util_AbstractList$IteratorImpl_$next__Ljava_util_AbstractList$IteratorImpl_2Ljava_lang_Object_2(this.java_util_AbstractMap$1$1_val$outerIter.java_util_AbstractHashMap$EntrySetIterator_iter), 27);
  return entry.getKey__Ljava_lang_Object_2();
}
;
_.java_lang_Object_castableTypeMap$ = {};
_.java_util_AbstractMap$1$1_val$outerIter = null;
function java_util_ArrayList_$add__Ljava_util_ArrayList_2Ljava_lang_Object_2Z(this$static, o){
  com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this$static.java_util_ArrayList_array, this$static.java_util_ArrayList_size++, o);
  return true;
}

function java_util_ArrayList_$indexOf__Ljava_util_ArrayList_2Ljava_lang_Object_2II(this$static, o, index){
  for (; index < this$static.java_util_ArrayList_size; ++index) {
    if (java_util_Utility_equalsWithNullCheck__Ljava_lang_Object_2Ljava_lang_Object_2Z(o, this$static.java_util_ArrayList_array[index])) {
      return index;
    }
  }
  return -1;
}

function java_util_ArrayList_ArrayList__V(){
  this.java_util_ArrayList_array = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1Object_12_1classLit, {23:1}, 0, 0, 0);
}

function java_util_ArrayList(){
}

_ = java_util_ArrayList_ArrayList__V.prototype = java_util_ArrayList.prototype = new java_util_AbstractList;
_.add__Ljava_lang_Object_2Z = function java_util_ArrayList_add__Ljava_lang_Object_2Z(o){
  return com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(this.java_util_ArrayList_array, this.java_util_ArrayList_size++, o) , true;
}
;
_.add__ILjava_lang_Object_2V = function java_util_ArrayList_add__ILjava_lang_Object_2V(index, o){
  (index < 0 || index > this.java_util_ArrayList_size) && java_util_AbstractList_indexOutOfBounds__IIV(index, this.java_util_ArrayList_size);
  this.java_util_ArrayList_array.splice(index, 0, o);
  ++this.java_util_ArrayList_size;
}
;
_.contains__Ljava_lang_Object_2Z = function java_util_ArrayList_contains__Ljava_lang_Object_2Z(o){
  return java_util_ArrayList_$indexOf__Ljava_util_ArrayList_2Ljava_lang_Object_2II(this, o, 0) != -1;
}
;
_.get__ILjava_lang_Object_2 = function java_util_ArrayList_get__ILjava_lang_Object_2(index){
  return java_util_AbstractList_checkIndex__IIV(index, this.java_util_ArrayList_size) , this.java_util_ArrayList_array[index];
}
;
_.size__I = function java_util_ArrayList_size__I(){
  return this.java_util_ArrayList_size;
}
;
_.toArray___3Ljava_lang_Object_2_3Ljava_lang_Object_2 = function java_util_ArrayList_toArray___3Ljava_lang_Object_2_3Ljava_lang_Object_2(out){
  var i, com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_a_0, com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_result_0;
  out.length < this.java_util_ArrayList_size && (out = (com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_a_0 = out , com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_result_0 = com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(0, this.java_util_ArrayList_size) , com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_a_0.com_google_gwt_lang_Array_arrayClass$, com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_a_0.java_lang_Object_castableTypeMap$, com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_a_0.com_google_gwt_lang_Array_queryId$, com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_result_0) , com_google_gwt_lang_Array_createFrom___3Ljava_lang_Object_2I_3Ljava_lang_Object_2_result_0));
  for (i = 0; i < this.java_util_ArrayList_size; ++i) {
    com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(out, i, this.java_util_ArrayList_array[i]);
  }
  out.length > this.java_util_ArrayList_size && com_google_gwt_lang_Array_setCheck__Lcom_google_gwt_lang_Array_2ILjava_lang_Object_2Ljava_lang_Object_2(out, this.java_util_ArrayList_size, null);
  return out;
}
;
_.java_lang_Object_castableTypeMap$ = {9:1, 23:1};
_.java_util_ArrayList_size = 0;
function java_util_Collections_$clinit__V(){
  java_util_Collections_$clinit__V = nullMethod;
  java_util_Collections_EMPTY_1LIST = new java_util_Collections$EmptyList_Collections$EmptyList__V;
}

var java_util_Collections_EMPTY_1LIST;
function java_util_Collections$EmptyList_Collections$EmptyList__V(){
}

function java_util_Collections$EmptyList(){
}

_ = java_util_Collections$EmptyList_Collections$EmptyList__V.prototype = java_util_Collections$EmptyList.prototype = new java_util_AbstractList;
_.contains__Ljava_lang_Object_2Z = function java_util_Collections$EmptyList_contains__Ljava_lang_Object_2Z(object){
  return false;
}
;
_.get__ILjava_lang_Object_2 = function java_util_Collections$EmptyList_get__ILjava_lang_Object_2(location){
  throw new java_lang_IndexOutOfBoundsException_IndexOutOfBoundsException__V;
}
;
_.size__I = function java_util_Collections$EmptyList_size__I(){
  return 0;
}
;
_.java_lang_Object_castableTypeMap$ = {9:1, 23:1};
function java_util_HashMap_$equals__Ljava_util_HashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Z(value1, value2){
  return (value1 == null?null:value1) === (value2 == null?null:value2) || value1 != null && com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(value1, value2);
}

function java_util_HashMap_HashMap__V(){
  java_util_AbstractHashMap_$clearImpl__Ljava_util_AbstractHashMap_2V(this);
}

function java_util_HashMap(){
}

_ = java_util_HashMap_HashMap__V.prototype = java_util_HashMap.prototype = new java_util_AbstractHashMap;
_.java_lang_Object_castableTypeMap$ = {8:1, 23:1};
function java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z(this$static, o){
  var old;
  old = java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(this$static.java_util_HashSet_map, o, this$static);
  return old == null;
}

function java_util_HashSet_HashSet__V(){
  this.java_util_HashSet_map = new java_util_HashMap_HashMap__V;
}

function java_util_HashSet(){
}

_ = java_util_HashSet_HashSet__V.prototype = java_util_HashSet.prototype = new java_util_AbstractSet;
_.add__Ljava_lang_Object_2Z = function java_util_HashSet_add__Ljava_lang_Object_2Z(o){
  var java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0;
  return java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0 = java_util_AbstractHashMap_$put__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(this.java_util_HashSet_map, o, this) , java_util_HashSet_$add__Ljava_util_HashSet_2Ljava_lang_Object_2Z_old_0 == null;
}
;
_.contains__Ljava_lang_Object_2Z = function java_util_HashSet_contains__Ljava_lang_Object_2Z(o){
  return java_util_AbstractHashMap_$containsKey__Ljava_util_AbstractHashMap_2Ljava_lang_Object_2Z(this.java_util_HashSet_map, o);
}
;
_.iterator__Ljava_util_Iterator_2 = function java_util_HashSet_iterator__Ljava_util_Iterator_2(){
  var java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0;
  return java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0 = new java_util_AbstractHashMap$EntrySetIterator_AbstractHashMap$EntrySetIterator__Ljava_util_AbstractHashMap_2V(java_util_AbstractMap_$keySet__Ljava_util_AbstractMap_2Ljava_util_Set_2(this.java_util_HashSet_map).java_util_AbstractMap$1_val$entrySet.java_util_AbstractHashMap$EntrySet_this$0) , new java_util_AbstractMap$1$1_AbstractMap$1$1__Ljava_util_AbstractMap$1_2V(java_util_AbstractMap$1_$iterator__Ljava_util_AbstractMap$1_2Ljava_util_Iterator_2_outerIter_0);
}
;
_.size__I = function java_util_HashSet_size__I(){
  return this.java_util_HashSet_map.java_util_AbstractHashMap_size;
}
;
_.java_lang_Object_castableTypeMap$ = {23:1, 28:1};
_.java_util_HashSet_map = null;
function java_util_MapEntryImpl_MapEntryImpl__Ljava_lang_Object_2Ljava_lang_Object_2V(key, value){
  this.java_util_MapEntryImpl_key = key;
  this.java_util_MapEntryImpl_value = value;
}

function java_util_MapEntryImpl(){
}

_ = java_util_MapEntryImpl_MapEntryImpl__Ljava_lang_Object_2Ljava_lang_Object_2V.prototype = java_util_MapEntryImpl.prototype = new java_util_AbstractMapEntry;
_.getKey__Ljava_lang_Object_2 = function java_util_MapEntryImpl_getKey__Ljava_lang_Object_2(){
  return this.java_util_MapEntryImpl_key;
}
;
_.getValue__Ljava_lang_Object_2 = function java_util_MapEntryImpl_getValue__Ljava_lang_Object_2(){
  return this.java_util_MapEntryImpl_value;
}
;
_.setValue__Ljava_lang_Object_2Ljava_lang_Object_2 = function java_util_MapEntryImpl_setValue__Ljava_lang_Object_2Ljava_lang_Object_2(value){
  var old;
  old = this.java_util_MapEntryImpl_value;
  this.java_util_MapEntryImpl_value = value;
  return old;
}
;
_.java_lang_Object_castableTypeMap$ = {27:1};
_.java_util_MapEntryImpl_key = null;
_.java_util_MapEntryImpl_value = null;
function java_util_NoSuchElementException_NoSuchElementException__V(){
  com_google_gwt_core_client_impl_StackTraceCreator$Collector_$fillInStackTrace__Lcom_google_gwt_core_client_impl_StackTraceCreator$Collector_2Ljava_lang_Throwable_2V();
}

function java_util_NoSuchElementException(){
}

_ = java_util_NoSuchElementException_NoSuchElementException__V.prototype = java_util_NoSuchElementException.prototype = new java_lang_RuntimeException;
_.java_lang_Object_castableTypeMap$ = {2:1, 7:1, 23:1};
function java_util_Utility_equalsWithNullCheck__Ljava_lang_Object_2Ljava_lang_Object_2Z(a, b){
  return (a == null?null:a) === (b == null?null:b) || a != null && com_google_gwt_core_client_JavaScriptObject_equals_1_1devirtual$__Ljava_lang_Object_2Ljava_lang_Object_2Z(a, b);
}

var $entry = com_google_gwt_core_client_impl_Impl_entry__Lcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2;
function gwtOnLoad(errFn, modName, modBase, softPermutationId){
  $moduleName = modName;
  $moduleBase = modBase;
  if (errFn)
    try {
      $entry(com_google_gwt_lang_EntryMethodHolder_init__V)();
    }
     catch (e) {
      errFn(modName);
    }
   else {
    $entry(com_google_gwt_lang_EntryMethodHolder_init__V)();
  }
}

var com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1StackTraceElement_12_1classLit = new java_lang_Class_Class__V, com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1Throwable_12_1classLit = new java_lang_Class_Class__V, com_google_gwt_lang_ClassLiteralHolder__13Lcom_1google_1gwt_1i18n_1client_1HasDirection$Direction_12_1classLit = new java_lang_Class_Class__V, com_google_gwt_lang_ClassLiteralHolder__13Lcom_1google_1gwt_1user_1client_1ui_1Widget_12_1classLit = new java_lang_Class_Class__V, com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1Object_12_1classLit = new java_lang_Class_Class__V;
$stats && $stats({moduleName:'deploymentgadget',sessionId:$sessionId,subSystem:'startup',evtGroup:'moduleStartup',millis:(new Date()).getTime(),type:'moduleEvalEnd'});
if (deploymentgadget && deploymentgadget.onScriptLoad)deploymentgadget.onScriptLoad(gwtOnLoad);
})();
