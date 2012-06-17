package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class Main  
{ 
  protected static final boolean TRACES_ENABLED = true;

  protected static ITermFactory constantFactory;

  private static WeakReference<Context> initedContext;

  private static boolean isIniting;

  protected static IStrategoTerm const268;

  protected static IStrategoTerm const267;

  protected static IStrategoTerm const266;

  protected static IStrategoTerm const265;

  protected static IStrategoTerm const264;

  protected static IStrategoTerm constCritical0;

  protected static IStrategoTerm const263;

  protected static IStrategoTerm const262;

  protected static IStrategoTerm const261;

  protected static IStrategoTerm const260;

  protected static IStrategoTerm const259;

  protected static IStrategoTerm const258;

  protected static IStrategoTerm const257;

  protected static IStrategoTerm const256;

  protected static IStrategoTerm const255;

  protected static IStrategoTerm const254;

  protected static IStrategoTerm const253;

  protected static IStrategoTerm const252;

  protected static IStrategoTerm const251;

  protected static IStrategoTerm const250;

  protected static IStrategoTerm const249;

  protected static IStrategoTerm const248;

  protected static IStrategoTerm constCons83;

  protected static IStrategoTerm constDR_DUMMY0;

  protected static IStrategoTerm const247;

  public static IStrategoTerm getEditorServiceprettyPpAf()
  { 
    return constEditorServiceprettyPpAf;
  }

  protected static ImportTerm constEditorServiceprettyPpAf;

  protected static IStrategoTerm const246;

  protected static IStrategoTerm constattrs0;

  protected static IStrategoTerm const245;

  protected static IStrategoTerm constCons82;

  protected static IStrategoTerm const244;

  protected static IStrategoTerm constCons81;

  protected static IStrategoTerm const243;

  protected static IStrategoTerm const242;

  protected static IStrategoTerm const241;

  protected static IStrategoTerm const240;

  protected static IStrategoTerm const239;

  protected static IStrategoTerm const238;

  protected static IStrategoTerm const237;

  protected static IStrategoTerm const236;

  protected static IStrategoTerm constTemplateOption0;

  protected static IStrategoTerm const235;

  protected static IStrategoTerm constTemplateBySortCons0;

  protected static IStrategoTerm const234;

  protected static IStrategoTerm const233;

  protected static IStrategoTerm constCons80;

  protected static IStrategoTerm const232;

  protected static IStrategoTerm const231;

  protected static IStrategoTerm const230;

  protected static IStrategoTerm const229;

  protected static IStrategoTerm const228;

  protected static IStrategoTerm const227;

  protected static IStrategoTerm const226;

  protected static IStrategoTerm const225;

  protected static IStrategoTerm const224;

  protected static IStrategoTerm const223;

  protected static IStrategoTerm const222;

  protected static IStrategoTerm const221;

  protected static IStrategoTerm const220;

  protected static IStrategoTerm const219;

  protected static IStrategoTerm constTemplateBySort0;

  protected static IStrategoTerm const218;

  protected static IStrategoTerm const217;

  protected static IStrategoTerm const216;

  protected static IStrategoTerm const215;

  protected static IStrategoTerm const214;

  protected static IStrategoTerm const213;

  protected static IStrategoTerm constPlus0;

  protected static IStrategoTerm constStar0;

  protected static IStrategoTerm constOption0;

  protected static IStrategoTerm constNone0;

  protected static IStrategoTerm const212;

  protected static IStrategoTerm constLayout1;

  protected static IStrategoTerm const211;

  protected static IStrategoTerm const210;

  protected static IStrategoTerm constCons79;

  protected static IStrategoTerm const209;

  protected static IStrategoTerm const208;

  protected static IStrategoTerm const207;

  protected static IStrategoTerm const206;

  protected static IStrategoTerm const205;

  protected static IStrategoTerm constCons78;

  protected static IStrategoTerm constCursor0;

  protected static IStrategoTerm const204;

  protected static IStrategoTerm const203;

  protected static IStrategoTerm const202;

  protected static IStrategoTerm const201;

  protected static IStrategoTerm const200;

  protected static IStrategoTerm constCons77;

  protected static IStrategoTerm constBlank0;

  protected static IStrategoTerm constTokenize0;

  protected static IStrategoTerm constunquoted0;

  protected static IStrategoTerm const199;

  protected static IStrategoTerm constCons76;

  protected static IStrategoTerm constsort0;

  protected static IStrategoTerm const198;

  protected static IStrategoTerm const197;

  protected static IStrategoTerm constCons75;

  protected static IStrategoTerm const196;

  protected static IStrategoTerm const195;

  protected static IStrategoTerm constCons74;

  protected static IStrategoTerm constString0;

  protected static IStrategoTerm constlit0;

  protected static IStrategoTerm const194;

  protected static IStrategoTerm const193;

  protected static IStrategoTerm constNewlines0;

  protected static IStrategoTerm const192;

  protected static IStrategoTerm const191;

  protected static IStrategoTerm constno_attrs0;

  protected static IStrategoTerm const190;

  protected static IStrategoTerm const189;

  protected static IStrategoTerm constKeywordFollowRestriction0;

  protected static IStrategoTerm const188;

  protected static IStrategoTerm const187;

  protected static IStrategoTerm const186;

  protected static IStrategoTerm const185;

  protected static IStrategoTerm const184;

  protected static IStrategoTerm const183;

  protected static IStrategoTerm const182;

  protected static IStrategoTerm const181;

  protected static IStrategoTerm const180;

  protected static IStrategoTerm const179;

  protected static IStrategoTerm constSVar11;

  protected static IStrategoTerm const178;

  protected static IStrategoTerm const177;

  protected static IStrategoTerm constCons73;

  protected static IStrategoTerm const176;

  protected static IStrategoTerm const175;

  protected static IStrategoTerm const174;

  protected static IStrategoTerm constSVar10;

  protected static IStrategoTerm const173;

  protected static IStrategoTerm const172;

  protected static IStrategoTerm constNoAnnoList32;

  protected static IStrategoTerm constOp24;

  protected static IStrategoTerm constCons72;

  protected static IStrategoTerm constCons71;

  protected static IStrategoTerm constNoAnnoList31;

  protected static IStrategoTerm constList5;

  protected static IStrategoTerm constCons70;

  protected static IStrategoTerm constNoAnnoList30;

  protected static IStrategoTerm constOp23;

  protected static IStrategoTerm constCons69;

  protected static IStrategoTerm constNoAnnoList29;

  protected static IStrategoTerm constStr1;

  protected static IStrategoTerm constSVar9;

  protected static IStrategoTerm const171;

  protected static IStrategoTerm const170;

  protected static IStrategoTerm const169;

  protected static IStrategoTerm const168;

  protected static IStrategoTerm constVar3;

  protected static IStrategoTerm const167;

  protected static IStrategoTerm const166;

  protected static IStrategoTerm const165;

  protected static IStrategoTerm const164;

  protected static IStrategoTerm constLayout0;

  protected static IStrategoTerm constBuild11;

  protected static IStrategoTerm constNoAnnoList28;

  protected static IStrategoTerm constList4;

  protected static IStrategoTerm constCons68;

  protected static IStrategoTerm constNoAnnoList27;

  protected static IStrategoTerm constOp22;

  protected static IStrategoTerm constCons67;

  protected static IStrategoTerm constRootApp5;

  protected static IStrategoTerm constCallNoArgs2;

  protected static IStrategoTerm constSVar8;

  protected static IStrategoTerm const163;

  protected static IStrategoTerm const162;

  protected static IStrategoTerm const161;

  protected static IStrategoTerm const160;

  protected static IStrategoTerm const159;

  protected static IStrategoTerm constCons66;

  protected static IStrategoTerm constImports0;

  protected static IStrategoTerm constCons65;

  protected static IStrategoTerm constImport1;

  protected static IStrategoTerm const158;

  protected static IStrategoTerm constCons64;

  protected static IStrategoTerm constImport0;

  protected static IStrategoTerm const157;

  protected static IStrategoTerm constCons63;

  protected static IStrategoTerm constSignature0;

  protected static IStrategoTerm constCons62;

  protected static IStrategoTerm constConstructors0;

  protected static IStrategoTerm constCons61;

  protected static IStrategoTerm constOpDecl0;

  protected static IStrategoTerm constFunType0;

  protected static IStrategoTerm constCons60;

  protected static IStrategoTerm constConstType0;

  protected static IStrategoTerm constSortNoArgs0;

  protected static IStrategoTerm const156;

  protected static IStrategoTerm constCons59;

  protected static IStrategoTerm constStrategies0;

  protected static IStrategoTerm constCons58;

  protected static IStrategoTerm constSDef7;

  protected static IStrategoTerm constSeq4;

  protected static IStrategoTerm constLChoice11;

  protected static IStrategoTerm constMatch2;

  protected static IStrategoTerm constNoAnnoList26;

  protected static IStrategoTerm constOp21;

  protected static IStrategoTerm const155;

  protected static IStrategoTerm constCons57;

  protected static IStrategoTerm constSDef6;

  protected static IStrategoTerm constSeq3;

  protected static IStrategoTerm constLChoice10;

  protected static IStrategoTerm constBuild10;

  protected static IStrategoTerm constNoAnnoList25;

  protected static IStrategoTerm constOp20;

  protected static IStrategoTerm constCons56;

  protected static IStrategoTerm constSDef5;

  protected static IStrategoTerm constSeq2;

  protected static IStrategoTerm constLChoice9;

  protected static IStrategoTerm constBuild9;

  protected static IStrategoTerm constNoAnnoList24;

  protected static IStrategoTerm constOp19;

  protected static IStrategoTerm constCons55;

  protected static IStrategoTerm const154;

  protected static IStrategoTerm constCall5;

  protected static IStrategoTerm constSVar7;

  protected static IStrategoTerm const153;

  protected static IStrategoTerm constCons54;

  protected static IStrategoTerm constSDef4;

  protected static IStrategoTerm constChoice0;

  protected static IStrategoTerm constMatch1;

  protected static IStrategoTerm constNoAnnoList23;

  protected static IStrategoTerm constOp18;

  protected static IStrategoTerm constCons53;

  protected static IStrategoTerm constRootApp4;

  protected static IStrategoTerm const152;

  protected static IStrategoTerm constLRule0;

  protected static IStrategoTerm constRuleNoCond0;

  protected static IStrategoTerm constNoAnnoList22;

  protected static IStrategoTerm constOp17;

  protected static IStrategoTerm const151;

  protected static IStrategoTerm const150;

  protected static IStrategoTerm constCons52;

  protected static IStrategoTerm constSDef3;

  protected static IStrategoTerm constLChoice8;

  protected static IStrategoTerm constBuild8;

  protected static IStrategoTerm constNoAnnoList21;

  protected static IStrategoTerm constOp16;

  protected static IStrategoTerm constCons51;

  protected static IStrategoTerm constCons50;

  protected static IStrategoTerm constSDefT4;

  protected static IStrategoTerm constLChoice7;

  protected static IStrategoTerm constBuild7;

  protected static IStrategoTerm constNoAnnoList20;

  protected static IStrategoTerm constOp15;

  protected static IStrategoTerm constCons49;

  protected static IStrategoTerm constNoAnnoList19;

  protected static IStrategoTerm constList3;

  protected static IStrategoTerm constCons48;

  protected static IStrategoTerm constNoAnnoList18;

  protected static IStrategoTerm constOp14;

  protected static IStrategoTerm constCons47;

  protected static IStrategoTerm constNoAnnoList17;

  protected static IStrategoTerm constOp13;

  protected static IStrategoTerm const149;

  protected static IStrategoTerm constCons46;

  protected static IStrategoTerm constVar2;

  protected static IStrategoTerm constCons45;

  protected static IStrategoTerm constRootApp3;

  protected static IStrategoTerm constCall4;

  protected static IStrategoTerm constCons44;

  protected static IStrategoTerm constCall3;

  protected static IStrategoTerm constSVar6;

  protected static IStrategoTerm const148;

  protected static IStrategoTerm const147;

  protected static IStrategoTerm constCons43;

  protected static IStrategoTerm constDefaultVarDec3;

  protected static IStrategoTerm const146;

  protected static IStrategoTerm const145;

  protected static IStrategoTerm constCons42;

  protected static IStrategoTerm constSDefT3;

  protected static IStrategoTerm constSeq1;

  protected static IStrategoTerm constLChoice6;

  protected static IStrategoTerm constBuild6;

  protected static IStrategoTerm constNoAnnoList16;

  protected static IStrategoTerm constOp12;

  protected static IStrategoTerm constCons41;

  protected static IStrategoTerm constNoAnnoList15;

  protected static IStrategoTerm constList2;

  protected static IStrategoTerm constCons40;

  protected static IStrategoTerm constNoAnnoList14;

  protected static IStrategoTerm constOp11;

  protected static IStrategoTerm constCons39;

  protected static IStrategoTerm constNoAnnoList13;

  protected static IStrategoTerm constOp10;

  protected static IStrategoTerm const144;

  protected static IStrategoTerm constCons38;

  protected static IStrategoTerm constVar1;

  protected static IStrategoTerm constCons37;

  protected static IStrategoTerm constNoAnnoList12;

  protected static IStrategoTerm constOp9;

  protected static IStrategoTerm constCons36;

  protected static IStrategoTerm constCons35;

  protected static IStrategoTerm constRootApp2;

  protected static IStrategoTerm constId0;

  protected static IStrategoTerm const143;

  protected static IStrategoTerm constCall2;

  protected static IStrategoTerm constCons34;

  protected static IStrategoTerm constCallNoArgs1;

  protected static IStrategoTerm constSVar5;

  protected static IStrategoTerm const142;

  protected static IStrategoTerm constSVar4;

  protected static IStrategoTerm const141;

  protected static IStrategoTerm constCons33;

  protected static IStrategoTerm constDefaultVarDec2;

  protected static IStrategoTerm const140;

  protected static IStrategoTerm const139;

  protected static IStrategoTerm constCons32;

  protected static IStrategoTerm constSDef2;

  protected static IStrategoTerm constLChoice5;

  protected static IStrategoTerm constBuild5;

  protected static IStrategoTerm constNoAnnoList11;

  protected static IStrategoTerm constOp8;

  protected static IStrategoTerm constCons31;

  protected static IStrategoTerm constCons30;

  protected static IStrategoTerm constSDefT2;

  protected static IStrategoTerm constLChoice4;

  protected static IStrategoTerm constBuild4;

  protected static IStrategoTerm constNoAnnoList10;

  protected static IStrategoTerm constOp7;

  protected static IStrategoTerm const138;

  protected static IStrategoTerm const137;

  protected static IStrategoTerm constCons29;

  protected static IStrategoTerm constSDef1;

  protected static IStrategoTerm constLChoice3;

  protected static IStrategoTerm constBuild3;

  protected static IStrategoTerm constNoAnnoList9;

  protected static IStrategoTerm constOp6;

  protected static IStrategoTerm constCons28;

  protected static IStrategoTerm constSDefT1;

  protected static IStrategoTerm constLChoice2;

  protected static IStrategoTerm constBuild2;

  protected static IStrategoTerm constNoAnnoList8;

  protected static IStrategoTerm constOp5;

  protected static IStrategoTerm const136;

  protected static IStrategoTerm const135;

  protected static IStrategoTerm constCons27;

  protected static IStrategoTerm constSDef0;

  protected static IStrategoTerm constLChoice1;

  protected static IStrategoTerm constBuild1;

  protected static IStrategoTerm constNoAnnoList7;

  protected static IStrategoTerm constOp4;

  protected static IStrategoTerm constCons26;

  protected static IStrategoTerm constCons25;

  protected static IStrategoTerm constRootApp1;

  protected static IStrategoTerm constCons24;

  protected static IStrategoTerm constSDefT0;

  protected static IStrategoTerm constLChoice0;

  protected static IStrategoTerm constBuild0;

  protected static IStrategoTerm constNoAnnoList6;

  protected static IStrategoTerm constOp3;

  protected static IStrategoTerm constCons23;

  protected static IStrategoTerm constNoAnnoList5;

  protected static IStrategoTerm constList1;

  protected static IStrategoTerm constCons22;

  protected static IStrategoTerm constNoAnnoList4;

  protected static IStrategoTerm constOp2;

  protected static IStrategoTerm constCons21;

  protected static IStrategoTerm constNoAnnoList3;

  protected static IStrategoTerm constOp1;

  protected static IStrategoTerm const134;

  protected static IStrategoTerm constCons20;

  protected static IStrategoTerm constNoAnnoList2;

  protected static IStrategoTerm constStr0;

  protected static IStrategoTerm const133;

  protected static IStrategoTerm const132;

  protected static IStrategoTerm constCons19;

  protected static IStrategoTerm constRootApp0;

  protected static IStrategoTerm constSeq0;

  protected static IStrategoTerm constCallT0;

  protected static IStrategoTerm constCons18;

  protected static IStrategoTerm constNoAnnoList1;

  protected static IStrategoTerm constOp0;

  protected static IStrategoTerm constCons17;

  protected static IStrategoTerm constVar0;

  protected static IStrategoTerm const131;

  protected static IStrategoTerm constSVar3;

  protected static IStrategoTerm const130;

  protected static IStrategoTerm constCall1;

  protected static IStrategoTerm constCons16;

  protected static IStrategoTerm constCall0;

  protected static IStrategoTerm constCons15;

  protected static IStrategoTerm constCallNoArgs0;

  protected static IStrategoTerm constSVar2;

  protected static IStrategoTerm constSVar1;

  protected static IStrategoTerm const129;

  protected static IStrategoTerm constSVar0;

  protected static IStrategoTerm const128;

  protected static IStrategoTerm const127;

  protected static IStrategoTerm constMatch0;

  protected static IStrategoTerm constNoAnnoList0;

  protected static IStrategoTerm constList0;

  protected static IStrategoTerm constCons14;

  protected static IStrategoTerm constDefaultVarDec1;

  protected static IStrategoTerm const126;

  protected static IStrategoTerm constCons13;

  protected static IStrategoTerm constDefaultVarDec0;

  protected static IStrategoTerm const125;

  protected static IStrategoTerm const124;

  protected static IStrategoTerm const123;

  protected static IStrategoTerm constNil3;

  protected static IStrategoTerm const122;

  protected static IStrategoTerm const121;

  public static IStrategoConstructor _consConc_2;

  public static IStrategoConstructor _consSome_1;

  protected static IStrategoConstructor _consreject_0;

  protected static IStrategoConstructor _consbracket_0;

  protected static IStrategoConstructor _consCritical_0;

  protected static IStrategoConstructor _consci_lit_1;

  protected static IStrategoConstructor _conswith_arguments_2;

  protected static IStrategoConstructor _consconc_2;

  protected static IStrategoConstructor _consnon_transitive_1;

  protected static IStrategoConstructor _consalt_2;

  protected static IStrategoConstructor _consParenthetical_1;

  protected static IStrategoConstructor _consdiff_2;

  protected static IStrategoConstructor _consisect_2;

  protected static IStrategoConstructor _consunion_2;

  protected static IStrategoConstructor _conscomp_1;

  protected static IStrategoConstructor _consconc_grammars_2;

  protected static IStrategoConstructor _consquoted_1;

  protected static IStrategoConstructor _consfun_1;

  protected static IStrategoConstructor _consattrs_1;

  protected static IStrategoConstructor _conslabel_2;

  protected static IStrategoConstructor _consLabel_1;

  protected static IStrategoConstructor _consiter_sep_2;

  protected static IStrategoConstructor _consiter_star_sep_2;

  protected static IStrategoConstructor _consiter_1;

  protected static IStrategoConstructor _consiter_star_1;

  protected static IStrategoConstructor _consopt_1;

  protected static IStrategoConstructor _conslit_1;

  protected static IStrategoConstructor _consseq_2;

  protected static IStrategoConstructor _consunquoted_1;

  protected static IStrategoConstructor _consappl_2;

  protected static IStrategoConstructor _consdefault_1;

  protected static IStrategoConstructor _consterm_1;

  protected static IStrategoConstructor _consno_attrs_0;

  protected static IStrategoConstructor _consprod_3;

  protected static IStrategoConstructor _consfollow_2;

  protected static IStrategoConstructor _conslexical_restrictions_1;

  protected static IStrategoConstructor _conscontext_free_syntax_1;

  protected static IStrategoConstructor _consSort_2;

  protected static IStrategoConstructor _consOpDeclInj_1;

  protected static IStrategoConstructor _consNone_0;

  protected static IStrategoConstructor _consApp_2;

  protected static IStrategoConstructor _consTuple_1;

  protected static IStrategoConstructor _consSDefNoArgs_2;

  protected static IStrategoConstructor _consImport_1;

  protected static IStrategoConstructor _consImports_1;

  protected static IStrategoConstructor _consSortNoArgs_1;

  protected static IStrategoConstructor _consConstType_1;

  protected static IStrategoConstructor _consFunType_2;

  protected static IStrategoConstructor _consOpDecl_2;

  protected static IStrategoConstructor _consConstructors_1;

  protected static IStrategoConstructor _consSignature_1;

  protected static IStrategoConstructor _consRuleNoCond_2;

  protected static IStrategoConstructor _consLRule_1;

  protected static IStrategoConstructor _consChoice_2;

  protected static IStrategoConstructor _consId_0;

  protected static IStrategoConstructor _consSDef_3;

  protected static IStrategoConstructor _consStr_1;

  protected static IStrategoConstructor _consVar_1;

  protected static IStrategoConstructor _consCallT_3;

  protected static IStrategoConstructor _consCallNoArgs_1;

  protected static IStrategoConstructor _consSVar_1;

  protected static IStrategoConstructor _consCall_2;

  protected static IStrategoConstructor _consSeq_2;

  protected static IStrategoConstructor _consRootApp_1;

  protected static IStrategoConstructor _consOp_2;

  protected static IStrategoConstructor _consBuild_1;

  protected static IStrategoConstructor _consList_1;

  protected static IStrategoConstructor _consNoAnnoList_1;

  protected static IStrategoConstructor _consMatch_1;

  protected static IStrategoConstructor _consLChoice_2;

  protected static IStrategoConstructor _consDefaultVarDec_1;

  protected static IStrategoConstructor _consSDefT_4;

  protected static IStrategoConstructor _consModule_2;

  protected static IStrategoConstructor _conslexical_syntax_1;

  protected static IStrategoConstructor _consStrategies_1;

  protected static IStrategoConstructor _conssort_1;

  public static IStrategoConstructor _consdeprecated_0;

  public static IStrategoConstructor _consdeprecated_1;

  public static IStrategoConstructor _consTemplateProduction_3;

  public static IStrategoConstructor _consTemplateProductionWithCons_3;

  public static IStrategoConstructor _consHide_0;

  public static IStrategoConstructor _consWrap_0;

  public static IStrategoConstructor _consAnchor_0;

  public static IStrategoConstructor _consSeparator_1;

  public static IStrategoConstructor _consText_1;

  public static IStrategoConstructor _consWATER_1;

  public static IStrategoConstructor _consNoOptions_0;

  public static IStrategoConstructor _consOptions_1;

  public static IStrategoConstructor _consTemplateOptions_1;

  public static IStrategoConstructor _consTemplateSection_1;

  public static IStrategoConstructor _consSDFSection_1;

  public static IStrategoConstructor _consNewlines_1;

  public static IStrategoConstructor _consKeywordFollowRestriction_1;

  public static IStrategoConstructor _consTokenize_1;

  public static IStrategoConstructor _consLeading_0;

  public static IStrategoConstructor _consTrailing_0;

  public static IStrategoConstructor _consSeparating_0;

  public static IStrategoConstructor _conssimple_ref_group_1;

  public static IStrategoConstructor _consprods_ref_group_1;

  public static IStrategoConstructor _consassoc_ref_group_2;

  public static IStrategoConstructor _consSdfProduction_3;

  public static IStrategoConstructor _consSdfProductionWithCons_3;

  public static IStrategoConstructor _consSortCons_2;

  public static IStrategoConstructor _consPlaceholder_4;

  public static IStrategoConstructor _consStar_0;

  public static IStrategoConstructor _consPlus_0;

  public static IStrategoConstructor _consOption_0;

  public static IStrategoConstructor _consTemplate_1;

  public static IStrategoConstructor _consSingleLineTemplate_1;

  public static IStrategoConstructor _consLine_1;

  public static IStrategoConstructor _consEscape_1;

  public static IStrategoConstructor _consLayout_1;

  public static IStrategoConstructor _consCompilationUnit_1;

  public static IStrategoConstructor _consSort_1;

  public static IStrategoConstructor _consListSort_1;

  public static IStrategoConstructor _consString_1;

  public static IStrategoConstructor _consConstructorOnly_1;

  public static IStrategoConstructor _consConstructor_1;

  public static IStrategoConstructor _consSortAndConstructor_2;

  public static IStrategoConstructor _consSemanticProvider_1;

  public static IStrategoConstructor _consOnSave_2;

  public static IStrategoConstructor _consReferenceHoverRule_3;

  public static IStrategoConstructor _consReferenceRule_2;

  public static IStrategoConstructor _consHoverRule_2;

  public static IStrategoConstructor _consOccurrenceRule_2;

  public static IStrategoConstructor _consCompletionProposer_1;

  public static IStrategoConstructor _consCompletionKeyword_2;

  public static IStrategoConstructor _consCompletionTemplate_3;

  public static IStrategoConstructor _consCompletionTemplateWithSort_4;

  public static IStrategoConstructor _consCompletionTrigger_2;

  public static IStrategoConstructor _consCompletionTemplateEx_4;

  public static IStrategoConstructor _consSemanticObserver_1;

  public static IStrategoConstructor _consBuilder_3;

  public static IStrategoConstructor _consBuilderCaption_1;

  public static IStrategoConstructor _consPPTable_1;

  public static IStrategoConstructor _consPrettyPrint_1;

  public static IStrategoConstructor _consRefactoring_4;

  public static IStrategoConstructor _consStrategy_1;

  public static IStrategoConstructor _consAttribute_1;

  public static IStrategoConstructor _consLanguage_2;

  public static IStrategoConstructor _consFolding_2;

  public static IStrategoConstructor _consOutliner_2;

  public static IStrategoConstructor _consColorer_2;

  public static IStrategoConstructor _consReferences_2;

  public static IStrategoConstructor _consCompletions_2;

  public static IStrategoConstructor _consBuilders_2;

  public static IStrategoConstructor _consRefactorings_2;

  public static IStrategoConstructor _consValues_1;

  public static IStrategoConstructor _consLanguageName_1;

  public static IStrategoConstructor _consLanguageId_1;

  public static IStrategoConstructor _consExtensions_1;

  public static IStrategoConstructor _consDescription_1;

  public static IStrategoConstructor _consTable_1;

  public static IStrategoConstructor _consTableProvider_1;

  public static IStrategoConstructor _consStartSymbols_1;

  public static IStrategoConstructor _consURL_1;

  public static IStrategoConstructor _consExtends_1;

  public static IStrategoConstructor _consAliases_1;

  public static IStrategoConstructor _consUnmanagedTablePrefix_1;

  public static IStrategoConstructor _consLineCommentPrefix_1;

  public static IStrategoConstructor _consBlockCommentDefs_1;

  public static IStrategoConstructor _consFenceDefs_1;

  public static IStrategoConstructor _consIndentDefs_1;

  public static IStrategoConstructor _consIdentifierLexical_1;

  public static IStrategoConstructor _consBlockCommentDef_3;

  public static IStrategoConstructor _consNoContinuation_0;

  public static IStrategoConstructor _consFenceDef_2;

  public static IStrategoConstructor _consIndentDef_1;

  public static IStrategoConstructor _consFoldRule_2;

  public static IStrategoConstructor _consFoldRuleAll_2;

  public static IStrategoConstructor _consFolded_0;

  public static IStrategoConstructor _consOutlineRule_1;

  public static IStrategoConstructor _consColorRuleAll_2;

  public static IStrategoConstructor _consColorRule_2;

  public static IStrategoConstructor _consColorRuleAllNamed_3;

  public static IStrategoConstructor _consColorRuleNamed_3;

  public static IStrategoConstructor _consColorDef_2;

  public static IStrategoConstructor _consAttribute_3;

  public static IStrategoConstructor _consAttributeRef_1;

  public static IStrategoConstructor _consToken_1;

  public static IStrategoConstructor _consLiteral_1;

  public static IStrategoConstructor _consTK_IDENTIFIER_0;

  public static IStrategoConstructor _consTK_NUMBER_0;

  public static IStrategoConstructor _consTK_LAYOUT_0;

  public static IStrategoConstructor _consTK_STRING_0;

  public static IStrategoConstructor _consTK_KEYWORD_0;

  public static IStrategoConstructor _consTK_OPERATOR_0;

  public static IStrategoConstructor _consTK_VAR_0;

  public static IStrategoConstructor _consTK_ERROR_0;

  public static IStrategoConstructor _consTK_UNKNOWN_0;

  public static IStrategoConstructor _consNORMAL_0;

  public static IStrategoConstructor _consBOLD_0;

  public static IStrategoConstructor _consITALIC_0;

  public static IStrategoConstructor _consBOLD_ITALIC_0;

  public static IStrategoConstructor _consColorDefault_0;

  public static IStrategoConstructor _consColorRGB_3;

  public static IStrategoConstructor _consNoColor_0;

  public static IStrategoConstructor _consNoCompletionPrefix_0;

  public static IStrategoConstructor _consCompletionPrefix_1;

  public static IStrategoConstructor _consPlaceholder_1;

  public static IStrategoConstructor _consPlaceholderWithSort_2;

  public static IStrategoConstructor _consDisable_0;

  public static IStrategoConstructor _consBlank_0;

  public static IStrategoConstructor _consLinked_0;

  public static IStrategoConstructor _consOpenEditor_0;

  public static IStrategoConstructor _consRealTime_0;

  public static IStrategoConstructor _consPersistent_0;

  public static IStrategoConstructor _consMeta_0;

  public static IStrategoConstructor _consCursor_0;

  public static IStrategoConstructor _consSource_0;

  public static IStrategoConstructor _consModule_3;

  public static IStrategoConstructor _consNoImports_0;

  public static IStrategoConstructor _consImportRenamed_2;

  public static IStrategoConstructor _consDR_DUMMY_0;

  public static IStrategoConstructor _consDR_UNDEFINE_1;

  public static IStrategoConstructor _consTokenize_0;

  public static IStrategoConstructor _consKeywordFollowRestriction_0;

  public static IStrategoConstructor _consNewlines_0;

  public static IStrategoConstructor _consTemplateOption_0;

  public static IStrategoConstructor _consTemplateBySortCons_0;

  public static IStrategoConstructor _consTemplateBySort_0;

  public static IStrategoConstructor _consDesugared_1;

  public static Context init(Context context)
  { 
    synchronized(Main.class)
    { 
      if(isIniting)
        return null;
      try
      { 
        isIniting = true;
        ITermFactory termFactory = context.getFactory();
        if(constantFactory == null)
        { 
          initConstructors(termFactory);
          initConstants(termFactory);
        }
        if(initedContext == null || initedContext.get() != context)
        { 
          org.strategoxt.stratego_lib.Main.init(context);
          org.strategoxt.stratego_lib.Main.init(context);
          org.strategoxt.stratego_sglr.Main.init(context);
          org.strategoxt.stratego_gpp.Main.init(context);
          org.strategoxt.stratego_xtc.Main.init(context);
          org.strategoxt.stratego_aterm.Main.init(context);
          org.strategoxt.stratego_sdf.Main.init(context);
          org.strategoxt.strc.Main.init(context);
          org.strategoxt.imp.editors.template.generated.Main.init(context);
          org.strategoxt.java_front.Main.init(context);
          context.registerComponent("generated");
        }
        initedContext = new WeakReference<Context>(context);
        constantFactory = termFactory;
      }
      finally
      { 
        isIniting = false;
      }
      return context;
    }
  }

  public static Context init()
  { 
    return init(new Context());
  }

  public static Strategy getMainStrategy()
  { 
    return null;
  }

  public static void initConstructors(ITermFactory termFactory)
  { 
    _consConc_2 = termFactory.makeConstructor("Conc", 2);
    _consSome_1 = termFactory.makeConstructor("Some", 1);
    _consreject_0 = termFactory.makeConstructor("reject", 0);
    _consbracket_0 = termFactory.makeConstructor("bracket", 0);
    _consCritical_0 = termFactory.makeConstructor("Critical", 0);
    _consci_lit_1 = termFactory.makeConstructor("ci-lit", 1);
    _conswith_arguments_2 = termFactory.makeConstructor("with-arguments", 2);
    _consconc_2 = termFactory.makeConstructor("conc", 2);
    _consnon_transitive_1 = termFactory.makeConstructor("non-transitive", 1);
    _consalt_2 = termFactory.makeConstructor("alt", 2);
    _consParenthetical_1 = termFactory.makeConstructor("Parenthetical", 1);
    _consdiff_2 = termFactory.makeConstructor("diff", 2);
    _consisect_2 = termFactory.makeConstructor("isect", 2);
    _consunion_2 = termFactory.makeConstructor("union", 2);
    _conscomp_1 = termFactory.makeConstructor("comp", 1);
    _consconc_grammars_2 = termFactory.makeConstructor("conc-grammars", 2);
    _consquoted_1 = termFactory.makeConstructor("quoted", 1);
    _consfun_1 = termFactory.makeConstructor("fun", 1);
    _consattrs_1 = termFactory.makeConstructor("attrs", 1);
    _conslabel_2 = termFactory.makeConstructor("label", 2);
    _consLabel_1 = termFactory.makeConstructor("Label", 1);
    _consiter_sep_2 = termFactory.makeConstructor("iter-sep", 2);
    _consiter_star_sep_2 = termFactory.makeConstructor("iter-star-sep", 2);
    _consiter_1 = termFactory.makeConstructor("iter", 1);
    _consiter_star_1 = termFactory.makeConstructor("iter-star", 1);
    _consopt_1 = termFactory.makeConstructor("opt", 1);
    _conslit_1 = termFactory.makeConstructor("lit", 1);
    _consseq_2 = termFactory.makeConstructor("seq", 2);
    _consunquoted_1 = termFactory.makeConstructor("unquoted", 1);
    _consappl_2 = termFactory.makeConstructor("appl", 2);
    _consdefault_1 = termFactory.makeConstructor("default", 1);
    _consterm_1 = termFactory.makeConstructor("term", 1);
    _consno_attrs_0 = termFactory.makeConstructor("no-attrs", 0);
    _consprod_3 = termFactory.makeConstructor("prod", 3);
    _consfollow_2 = termFactory.makeConstructor("follow", 2);
    _conslexical_restrictions_1 = termFactory.makeConstructor("lexical-restrictions", 1);
    _conscontext_free_syntax_1 = termFactory.makeConstructor("context-free-syntax", 1);
    _consSort_2 = termFactory.makeConstructor("Sort", 2);
    _consOpDeclInj_1 = termFactory.makeConstructor("OpDeclInj", 1);
    _consNone_0 = termFactory.makeConstructor("None", 0);
    _consApp_2 = termFactory.makeConstructor("App", 2);
    _consTuple_1 = termFactory.makeConstructor("Tuple", 1);
    _consSDefNoArgs_2 = termFactory.makeConstructor("SDefNoArgs", 2);
    _consImport_1 = termFactory.makeConstructor("Import", 1);
    _consImports_1 = termFactory.makeConstructor("Imports", 1);
    _consSortNoArgs_1 = termFactory.makeConstructor("SortNoArgs", 1);
    _consConstType_1 = termFactory.makeConstructor("ConstType", 1);
    _consFunType_2 = termFactory.makeConstructor("FunType", 2);
    _consOpDecl_2 = termFactory.makeConstructor("OpDecl", 2);
    _consConstructors_1 = termFactory.makeConstructor("Constructors", 1);
    _consSignature_1 = termFactory.makeConstructor("Signature", 1);
    _consRuleNoCond_2 = termFactory.makeConstructor("RuleNoCond", 2);
    _consLRule_1 = termFactory.makeConstructor("LRule", 1);
    _consChoice_2 = termFactory.makeConstructor("Choice", 2);
    _consId_0 = termFactory.makeConstructor("Id", 0);
    _consSDef_3 = termFactory.makeConstructor("SDef", 3);
    _consStr_1 = termFactory.makeConstructor("Str", 1);
    _consVar_1 = termFactory.makeConstructor("Var", 1);
    _consCallT_3 = termFactory.makeConstructor("CallT", 3);
    _consCallNoArgs_1 = termFactory.makeConstructor("CallNoArgs", 1);
    _consSVar_1 = termFactory.makeConstructor("SVar", 1);
    _consCall_2 = termFactory.makeConstructor("Call", 2);
    _consSeq_2 = termFactory.makeConstructor("Seq", 2);
    _consRootApp_1 = termFactory.makeConstructor("RootApp", 1);
    _consOp_2 = termFactory.makeConstructor("Op", 2);
    _consBuild_1 = termFactory.makeConstructor("Build", 1);
    _consList_1 = termFactory.makeConstructor("List", 1);
    _consNoAnnoList_1 = termFactory.makeConstructor("NoAnnoList", 1);
    _consMatch_1 = termFactory.makeConstructor("Match", 1);
    _consLChoice_2 = termFactory.makeConstructor("LChoice", 2);
    _consDefaultVarDec_1 = termFactory.makeConstructor("DefaultVarDec", 1);
    _consSDefT_4 = termFactory.makeConstructor("SDefT", 4);
    _consModule_2 = termFactory.makeConstructor("Module", 2);
    _conslexical_syntax_1 = termFactory.makeConstructor("lexical-syntax", 1);
    _consStrategies_1 = termFactory.makeConstructor("Strategies", 1);
    _conssort_1 = termFactory.makeConstructor("sort", 1);
    _consdeprecated_0 = termFactory.makeConstructor("deprecated", 0);
    _consdeprecated_1 = termFactory.makeConstructor("deprecated", 1);
    _consTemplateProduction_3 = termFactory.makeConstructor("TemplateProduction", 3);
    _consTemplateProductionWithCons_3 = termFactory.makeConstructor("TemplateProductionWithCons", 3);
    _consHide_0 = termFactory.makeConstructor("Hide", 0);
    _consWrap_0 = termFactory.makeConstructor("Wrap", 0);
    _consAnchor_0 = termFactory.makeConstructor("Anchor", 0);
    _consSeparator_1 = termFactory.makeConstructor("Separator", 1);
    _consText_1 = termFactory.makeConstructor("Text", 1);
    _consWATER_1 = termFactory.makeConstructor("WATER", 1);
    _consNoOptions_0 = termFactory.makeConstructor("NoOptions", 0);
    _consOptions_1 = termFactory.makeConstructor("Options", 1);
    _consTemplateOptions_1 = termFactory.makeConstructor("TemplateOptions", 1);
    _consTemplateSection_1 = termFactory.makeConstructor("TemplateSection", 1);
    _consSDFSection_1 = termFactory.makeConstructor("SDFSection", 1);
    _consNewlines_1 = termFactory.makeConstructor("Newlines", 1);
    _consKeywordFollowRestriction_1 = termFactory.makeConstructor("KeywordFollowRestriction", 1);
    _consTokenize_1 = termFactory.makeConstructor("Tokenize", 1);
    _consLeading_0 = termFactory.makeConstructor("Leading", 0);
    _consTrailing_0 = termFactory.makeConstructor("Trailing", 0);
    _consSeparating_0 = termFactory.makeConstructor("Separating", 0);
    _conssimple_ref_group_1 = termFactory.makeConstructor("simple-ref-group", 1);
    _consprods_ref_group_1 = termFactory.makeConstructor("prods-ref-group", 1);
    _consassoc_ref_group_2 = termFactory.makeConstructor("assoc-ref-group", 2);
    _consSdfProduction_3 = termFactory.makeConstructor("SdfProduction", 3);
    _consSdfProductionWithCons_3 = termFactory.makeConstructor("SdfProductionWithCons", 3);
    _consSortCons_2 = termFactory.makeConstructor("SortCons", 2);
    _consPlaceholder_4 = termFactory.makeConstructor("Placeholder", 4);
    _consStar_0 = termFactory.makeConstructor("Star", 0);
    _consPlus_0 = termFactory.makeConstructor("Plus", 0);
    _consOption_0 = termFactory.makeConstructor("Option", 0);
    _consTemplate_1 = termFactory.makeConstructor("Template", 1);
    _consSingleLineTemplate_1 = termFactory.makeConstructor("SingleLineTemplate", 1);
    _consLine_1 = termFactory.makeConstructor("Line", 1);
    _consEscape_1 = termFactory.makeConstructor("Escape", 1);
    _consLayout_1 = termFactory.makeConstructor("Layout", 1);
    _consCompilationUnit_1 = termFactory.makeConstructor("CompilationUnit", 1);
    _consSort_1 = termFactory.makeConstructor("Sort", 1);
    _consListSort_1 = termFactory.makeConstructor("ListSort", 1);
    _consString_1 = termFactory.makeConstructor("String", 1);
    _consConstructorOnly_1 = termFactory.makeConstructor("ConstructorOnly", 1);
    _consConstructor_1 = termFactory.makeConstructor("Constructor", 1);
    _consSortAndConstructor_2 = termFactory.makeConstructor("SortAndConstructor", 2);
    _consSemanticProvider_1 = termFactory.makeConstructor("SemanticProvider", 1);
    _consOnSave_2 = termFactory.makeConstructor("OnSave", 2);
    _consReferenceHoverRule_3 = termFactory.makeConstructor("ReferenceHoverRule", 3);
    _consReferenceRule_2 = termFactory.makeConstructor("ReferenceRule", 2);
    _consHoverRule_2 = termFactory.makeConstructor("HoverRule", 2);
    _consOccurrenceRule_2 = termFactory.makeConstructor("OccurrenceRule", 2);
    _consCompletionProposer_1 = termFactory.makeConstructor("CompletionProposer", 1);
    _consCompletionKeyword_2 = termFactory.makeConstructor("CompletionKeyword", 2);
    _consCompletionTemplate_3 = termFactory.makeConstructor("CompletionTemplate", 3);
    _consCompletionTemplateWithSort_4 = termFactory.makeConstructor("CompletionTemplateWithSort", 4);
    _consCompletionTrigger_2 = termFactory.makeConstructor("CompletionTrigger", 2);
    _consCompletionTemplateEx_4 = termFactory.makeConstructor("CompletionTemplateEx", 4);
    _consSemanticObserver_1 = termFactory.makeConstructor("SemanticObserver", 1);
    _consBuilder_3 = termFactory.makeConstructor("Builder", 3);
    _consBuilderCaption_1 = termFactory.makeConstructor("BuilderCaption", 1);
    _consPPTable_1 = termFactory.makeConstructor("PPTable", 1);
    _consPrettyPrint_1 = termFactory.makeConstructor("PrettyPrint", 1);
    _consRefactoring_4 = termFactory.makeConstructor("Refactoring", 4);
    _consStrategy_1 = termFactory.makeConstructor("Strategy", 1);
    _consAttribute_1 = termFactory.makeConstructor("Attribute", 1);
    _consLanguage_2 = termFactory.makeConstructor("Language", 2);
    _consFolding_2 = termFactory.makeConstructor("Folding", 2);
    _consOutliner_2 = termFactory.makeConstructor("Outliner", 2);
    _consColorer_2 = termFactory.makeConstructor("Colorer", 2);
    _consReferences_2 = termFactory.makeConstructor("References", 2);
    _consCompletions_2 = termFactory.makeConstructor("Completions", 2);
    _consBuilders_2 = termFactory.makeConstructor("Builders", 2);
    _consRefactorings_2 = termFactory.makeConstructor("Refactorings", 2);
    _consValues_1 = termFactory.makeConstructor("Values", 1);
    _consLanguageName_1 = termFactory.makeConstructor("LanguageName", 1);
    _consLanguageId_1 = termFactory.makeConstructor("LanguageId", 1);
    _consExtensions_1 = termFactory.makeConstructor("Extensions", 1);
    _consDescription_1 = termFactory.makeConstructor("Description", 1);
    _consTable_1 = termFactory.makeConstructor("Table", 1);
    _consTableProvider_1 = termFactory.makeConstructor("TableProvider", 1);
    _consStartSymbols_1 = termFactory.makeConstructor("StartSymbols", 1);
    _consURL_1 = termFactory.makeConstructor("URL", 1);
    _consExtends_1 = termFactory.makeConstructor("Extends", 1);
    _consAliases_1 = termFactory.makeConstructor("Aliases", 1);
    _consUnmanagedTablePrefix_1 = termFactory.makeConstructor("UnmanagedTablePrefix", 1);
    _consLineCommentPrefix_1 = termFactory.makeConstructor("LineCommentPrefix", 1);
    _consBlockCommentDefs_1 = termFactory.makeConstructor("BlockCommentDefs", 1);
    _consFenceDefs_1 = termFactory.makeConstructor("FenceDefs", 1);
    _consIndentDefs_1 = termFactory.makeConstructor("IndentDefs", 1);
    _consIdentifierLexical_1 = termFactory.makeConstructor("IdentifierLexical", 1);
    _consBlockCommentDef_3 = termFactory.makeConstructor("BlockCommentDef", 3);
    _consNoContinuation_0 = termFactory.makeConstructor("NoContinuation", 0);
    _consFenceDef_2 = termFactory.makeConstructor("FenceDef", 2);
    _consIndentDef_1 = termFactory.makeConstructor("IndentDef", 1);
    _consFoldRule_2 = termFactory.makeConstructor("FoldRule", 2);
    _consFoldRuleAll_2 = termFactory.makeConstructor("FoldRuleAll", 2);
    _consFolded_0 = termFactory.makeConstructor("Folded", 0);
    _consOutlineRule_1 = termFactory.makeConstructor("OutlineRule", 1);
    _consColorRuleAll_2 = termFactory.makeConstructor("ColorRuleAll", 2);
    _consColorRule_2 = termFactory.makeConstructor("ColorRule", 2);
    _consColorRuleAllNamed_3 = termFactory.makeConstructor("ColorRuleAllNamed", 3);
    _consColorRuleNamed_3 = termFactory.makeConstructor("ColorRuleNamed", 3);
    _consColorDef_2 = termFactory.makeConstructor("ColorDef", 2);
    _consAttribute_3 = termFactory.makeConstructor("Attribute", 3);
    _consAttributeRef_1 = termFactory.makeConstructor("AttributeRef", 1);
    _consToken_1 = termFactory.makeConstructor("Token", 1);
    _consLiteral_1 = termFactory.makeConstructor("Literal", 1);
    _consTK_IDENTIFIER_0 = termFactory.makeConstructor("TK_IDENTIFIER", 0);
    _consTK_NUMBER_0 = termFactory.makeConstructor("TK_NUMBER", 0);
    _consTK_LAYOUT_0 = termFactory.makeConstructor("TK_LAYOUT", 0);
    _consTK_STRING_0 = termFactory.makeConstructor("TK_STRING", 0);
    _consTK_KEYWORD_0 = termFactory.makeConstructor("TK_KEYWORD", 0);
    _consTK_OPERATOR_0 = termFactory.makeConstructor("TK_OPERATOR", 0);
    _consTK_VAR_0 = termFactory.makeConstructor("TK_VAR", 0);
    _consTK_ERROR_0 = termFactory.makeConstructor("TK_ERROR", 0);
    _consTK_UNKNOWN_0 = termFactory.makeConstructor("TK_UNKNOWN", 0);
    _consNORMAL_0 = termFactory.makeConstructor("NORMAL", 0);
    _consBOLD_0 = termFactory.makeConstructor("BOLD", 0);
    _consITALIC_0 = termFactory.makeConstructor("ITALIC", 0);
    _consBOLD_ITALIC_0 = termFactory.makeConstructor("BOLD_ITALIC", 0);
    _consColorDefault_0 = termFactory.makeConstructor("ColorDefault", 0);
    _consColorRGB_3 = termFactory.makeConstructor("ColorRGB", 3);
    _consNoColor_0 = termFactory.makeConstructor("NoColor", 0);
    _consNoCompletionPrefix_0 = termFactory.makeConstructor("NoCompletionPrefix", 0);
    _consCompletionPrefix_1 = termFactory.makeConstructor("CompletionPrefix", 1);
    _consPlaceholder_1 = termFactory.makeConstructor("Placeholder", 1);
    _consPlaceholderWithSort_2 = termFactory.makeConstructor("PlaceholderWithSort", 2);
    _consDisable_0 = termFactory.makeConstructor("Disable", 0);
    _consBlank_0 = termFactory.makeConstructor("Blank", 0);
    _consLinked_0 = termFactory.makeConstructor("Linked", 0);
    _consOpenEditor_0 = termFactory.makeConstructor("OpenEditor", 0);
    _consRealTime_0 = termFactory.makeConstructor("RealTime", 0);
    _consPersistent_0 = termFactory.makeConstructor("Persistent", 0);
    _consMeta_0 = termFactory.makeConstructor("Meta", 0);
    _consCursor_0 = termFactory.makeConstructor("Cursor", 0);
    _consSource_0 = termFactory.makeConstructor("Source", 0);
    _consModule_3 = termFactory.makeConstructor("Module", 3);
    _consNoImports_0 = termFactory.makeConstructor("NoImports", 0);
    _consImportRenamed_2 = termFactory.makeConstructor("ImportRenamed", 2);
    _consDR_DUMMY_0 = termFactory.makeConstructor("DR_DUMMY", 0);
    _consDR_UNDEFINE_1 = termFactory.makeConstructor("DR_UNDEFINE", 1);
    _consTokenize_0 = termFactory.makeConstructor("Tokenize", 0);
    _consKeywordFollowRestriction_0 = termFactory.makeConstructor("KeywordFollowRestriction", 0);
    _consNewlines_0 = termFactory.makeConstructor("Newlines", 0);
    _consTemplateOption_0 = termFactory.makeConstructor("TemplateOption", 0);
    _consTemplateBySortCons_0 = termFactory.makeConstructor("TemplateBySortCons", 0);
    _consTemplateBySort_0 = termFactory.makeConstructor("TemplateBySort", 0);
    _consDesugared_1 = termFactory.makeConstructor("Desugared", 1);
  }

  public static void initConstants(ITermFactory termFactory)
  { 
    const121 = termFactory.makeString("");
    const122 = termFactory.makeString("Failed to convert TemplateSection to stratego pretty printer");
    constNil3 = (IStrategoTerm)termFactory.makeList(Term.NO_TERMS);
    const123 = termFactory.makeString("Failed to convert lexical-syntax to stratego pretty printer");
    const124 = termFactory.makeString("pp-HZ-list");
    const125 = termFactory.makeString("pp");
    constDefaultVarDec0 = termFactory.makeAppl(Main._consDefaultVarDec_1, new IStrategoTerm[]{generated.const125});
    constCons13 = (IStrategoTerm)termFactory.makeListCons(generated.constDefaultVarDec0, (IStrategoList)generated.constNil3);
    const126 = termFactory.makeString("sep");
    constDefaultVarDec1 = termFactory.makeAppl(Main._consDefaultVarDec_1, new IStrategoTerm[]{generated.const126});
    constCons14 = (IStrategoTerm)termFactory.makeListCons(generated.constDefaultVarDec1, (IStrategoList)generated.constNil3);
    constList0 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constNil3});
    constNoAnnoList0 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList0});
    constMatch0 = termFactory.makeAppl(Main._consMatch_1, new IStrategoTerm[]{generated.constNoAnnoList0});
    const127 = termFactory.makeString("HZ");
    const128 = termFactory.makeString("map");
    constSVar0 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const128});
    const129 = termFactory.makeString("pp-one-Z");
    constSVar1 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const129});
    constSVar2 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const125});
    constCallNoArgs0 = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{generated.constSVar2});
    constCons15 = (IStrategoTerm)termFactory.makeListCons(generated.constCallNoArgs0, (IStrategoList)generated.constNil3);
    constCall0 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar1, generated.constCons15});
    constCons16 = (IStrategoTerm)termFactory.makeListCons(generated.constCall0, (IStrategoList)generated.constNil3);
    constCall1 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar0, generated.constCons16});
    const130 = termFactory.makeString("separate-by");
    constSVar3 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const130});
    const131 = termFactory.makeString("S");
    constVar0 = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{generated.const126});
    constCons17 = (IStrategoTerm)termFactory.makeListCons(generated.constVar0, (IStrategoList)generated.constNil3);
    constOp0 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const131, generated.constCons17});
    constNoAnnoList1 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp0});
    constCons18 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList1, (IStrategoList)generated.constNil3);
    constCallT0 = termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{generated.constSVar3, generated.constNil3, generated.constCons18});
    constSeq0 = termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{generated.constCall1, generated.constCallT0});
    constRootApp0 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constSeq0});
    constCons19 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp0, (IStrategoList)generated.constNil3);
    const132 = termFactory.makeString("SOpt");
    const133 = termFactory.makeString("0");
    constStr0 = termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{generated.const133});
    constNoAnnoList2 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constStr0});
    constCons20 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList2, (IStrategoList)generated.constNil3);
    const134 = termFactory.makeString("HS");
    constOp1 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const134, generated.constNil3});
    constNoAnnoList3 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp1});
    constCons21 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList3, (IStrategoList)generated.constCons20);
    constOp2 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const132, generated.constCons21});
    constNoAnnoList4 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp2});
    constCons22 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList4, (IStrategoList)generated.constNil3);
    constList1 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constCons22});
    constNoAnnoList5 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList1});
    constCons23 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList5, (IStrategoList)generated.constCons19);
    constOp3 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const127, generated.constCons23});
    constNoAnnoList6 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp3});
    constBuild0 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList6});
    constLChoice0 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild0});
    constSDefT0 = termFactory.makeAppl(Main._consSDefT_4, new IStrategoTerm[]{generated.const124, generated.constCons13, generated.constCons14, generated.constLChoice0});
    constCons24 = (IStrategoTerm)termFactory.makeListCons(generated.constSDefT0, (IStrategoList)generated.constNil3);
    constRootApp1 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constCall1});
    constCons25 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp1, (IStrategoList)generated.constNil3);
    constCons26 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList5, (IStrategoList)generated.constCons25);
    constOp4 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const127, generated.constCons26});
    constNoAnnoList7 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp4});
    constBuild1 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList7});
    constLChoice1 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild1});
    constSDef0 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const124, generated.constCons13, generated.constLChoice1});
    constCons27 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef0, (IStrategoList)generated.constCons24);
    const135 = termFactory.makeString("pp-HV-list");
    const136 = termFactory.makeString("HV");
    constOp5 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const136, generated.constCons23});
    constNoAnnoList8 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp5});
    constBuild2 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList8});
    constLChoice2 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild2});
    constSDefT1 = termFactory.makeAppl(Main._consSDefT_4, new IStrategoTerm[]{generated.const135, generated.constCons13, generated.constCons14, generated.constLChoice2});
    constCons28 = (IStrategoTerm)termFactory.makeListCons(generated.constSDefT1, (IStrategoList)generated.constCons27);
    constOp6 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const136, generated.constCons26});
    constNoAnnoList9 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp6});
    constBuild3 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList9});
    constLChoice3 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild3});
    constSDef1 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const135, generated.constCons13, generated.constLChoice3});
    constCons29 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef1, (IStrategoList)generated.constCons28);
    const137 = termFactory.makeString("pp-H-list");
    const138 = termFactory.makeString("H");
    constOp7 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const138, generated.constCons23});
    constNoAnnoList10 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp7});
    constBuild4 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList10});
    constLChoice4 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild4});
    constSDefT2 = termFactory.makeAppl(Main._consSDefT_4, new IStrategoTerm[]{generated.const137, generated.constCons13, generated.constCons14, generated.constLChoice4});
    constCons30 = (IStrategoTerm)termFactory.makeListCons(generated.constSDefT2, (IStrategoList)generated.constCons29);
    constCons31 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList0, (IStrategoList)generated.constCons25);
    constOp8 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const138, generated.constCons31});
    constNoAnnoList11 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp8});
    constBuild5 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList11});
    constLChoice5 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild5});
    constSDef2 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const137, generated.constCons13, generated.constLChoice5});
    constCons32 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef2, (IStrategoList)generated.constCons30);
    const139 = termFactory.makeString("pp-indent");
    const140 = termFactory.makeString("is");
    constDefaultVarDec2 = termFactory.makeAppl(Main._consDefaultVarDec_1, new IStrategoTerm[]{generated.const140});
    constCons33 = (IStrategoTerm)termFactory.makeListCons(generated.constDefaultVarDec2, (IStrategoList)generated.constNil3);
    const141 = termFactory.makeString("filter");
    constSVar4 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const141});
    const142 = termFactory.makeString("gpp-is-real-vbox");
    constSVar5 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const142});
    constCallNoArgs1 = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{generated.constSVar5});
    constCons34 = (IStrategoTerm)termFactory.makeListCons(generated.constCallNoArgs1, (IStrategoList)generated.constNil3);
    constCall2 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar4, generated.constCons34});
    const143 = termFactory.makeString("I");
    constId0 = termFactory.makeAppl(Main._consId_0, NO_TERMS);
    constRootApp2 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constId0});
    constCons35 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp2, (IStrategoList)generated.constNil3);
    constCons36 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList5, (IStrategoList)generated.constCons35);
    constOp9 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const138, generated.constCons36});
    constNoAnnoList12 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp9});
    constCons37 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList12, (IStrategoList)generated.constNil3);
    constVar1 = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{generated.const140});
    constCons38 = (IStrategoTerm)termFactory.makeListCons(generated.constVar1, (IStrategoList)generated.constNil3);
    const144 = termFactory.makeString("IS");
    constOp10 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const144, generated.constNil3});
    constNoAnnoList13 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp10});
    constCons39 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList13, (IStrategoList)generated.constCons38);
    constOp11 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const132, generated.constCons39});
    constNoAnnoList14 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp11});
    constCons40 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList14, (IStrategoList)generated.constNil3);
    constList2 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constCons40});
    constNoAnnoList15 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList2});
    constCons41 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList15, (IStrategoList)generated.constCons37);
    constOp12 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const143, generated.constCons41});
    constNoAnnoList16 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp12});
    constBuild6 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList16});
    constLChoice6 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild6});
    constSeq1 = termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{generated.constCall2, generated.constLChoice6});
    constSDefT3 = termFactory.makeAppl(Main._consSDefT_4, new IStrategoTerm[]{generated.const139, generated.constNil3, generated.constCons33, generated.constSeq1});
    constCons42 = (IStrategoTerm)termFactory.makeListCons(generated.constSDefT3, (IStrategoList)generated.constCons32);
    const145 = termFactory.makeString("pp-V-list");
    const146 = termFactory.makeString("vs");
    constDefaultVarDec3 = termFactory.makeAppl(Main._consDefaultVarDec_1, new IStrategoTerm[]{generated.const146});
    constCons43 = (IStrategoTerm)termFactory.makeListCons(generated.constDefaultVarDec3, (IStrategoList)generated.constNil3);
    const147 = termFactory.makeString("V");
    const148 = termFactory.makeString("pp-one-V");
    constSVar6 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const148});
    constCall3 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar6, generated.constCons15});
    constCons44 = (IStrategoTerm)termFactory.makeListCons(generated.constCall3, (IStrategoList)generated.constNil3);
    constCall4 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar0, generated.constCons44});
    constRootApp3 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constCall4});
    constCons45 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp3, (IStrategoList)generated.constNil3);
    constVar2 = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{generated.const146});
    constCons46 = (IStrategoTerm)termFactory.makeListCons(generated.constVar2, (IStrategoList)generated.constNil3);
    const149 = termFactory.makeString("VS");
    constOp13 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const149, generated.constNil3});
    constNoAnnoList17 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp13});
    constCons47 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList17, (IStrategoList)generated.constCons46);
    constOp14 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const132, generated.constCons47});
    constNoAnnoList18 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp14});
    constCons48 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList18, (IStrategoList)generated.constNil3);
    constList3 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constCons48});
    constNoAnnoList19 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList3});
    constCons49 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList19, (IStrategoList)generated.constCons45);
    constOp15 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const147, generated.constCons49});
    constNoAnnoList20 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp15});
    constBuild7 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList20});
    constLChoice7 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild7});
    constSDefT4 = termFactory.makeAppl(Main._consSDefT_4, new IStrategoTerm[]{generated.const145, generated.constCons13, generated.constCons43, generated.constLChoice7});
    constCons50 = (IStrategoTerm)termFactory.makeListCons(generated.constSDefT4, (IStrategoList)generated.constCons42);
    constCons51 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList0, (IStrategoList)generated.constCons45);
    constOp16 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const147, generated.constCons51});
    constNoAnnoList21 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp16});
    constBuild8 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList21});
    constLChoice8 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild8});
    constSDef3 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const145, generated.constCons13, generated.constLChoice8});
    constCons52 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef3, (IStrategoList)generated.constCons50);
    const150 = termFactory.makeString("pp-option");
    const151 = termFactory.makeString("None");
    constOp17 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const151, generated.constNil3});
    constNoAnnoList22 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp17});
    constRuleNoCond0 = termFactory.makeAppl(Main._consRuleNoCond_2, new IStrategoTerm[]{generated.constNoAnnoList22, generated.constNoAnnoList0});
    constLRule0 = termFactory.makeAppl(Main._consLRule_1, new IStrategoTerm[]{generated.constRuleNoCond0});
    const152 = termFactory.makeString("Some");
    constRootApp4 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constCallNoArgs0});
    constCons53 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp4, (IStrategoList)generated.constNil3);
    constOp18 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const152, generated.constCons53});
    constNoAnnoList23 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp18});
    constMatch1 = termFactory.makeAppl(Main._consMatch_1, new IStrategoTerm[]{generated.constNoAnnoList23});
    constChoice0 = termFactory.makeAppl(Main._consChoice_2, new IStrategoTerm[]{generated.constLRule0, generated.constMatch1});
    constSDef4 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const150, generated.constCons13, generated.constChoice0});
    constCons54 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef4, (IStrategoList)generated.constCons52);
    const153 = termFactory.makeString("pp-one");
    constSVar7 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const153});
    constCall5 = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar7, generated.constCons15});
    const154 = termFactory.makeString("Z");
    constCons55 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList0, (IStrategoList)generated.constCons35);
    constOp19 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const154, generated.constCons55});
    constNoAnnoList24 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp19});
    constBuild9 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList24});
    constLChoice9 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild9});
    constSeq2 = termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{generated.constCall5, generated.constLChoice9});
    constSDef5 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const129, generated.constCons13, generated.constSeq2});
    constCons56 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef5, (IStrategoList)generated.constCons54);
    constOp20 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const147, generated.constCons55});
    constNoAnnoList25 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp20});
    constBuild10 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList25});
    constLChoice10 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constMatch0, generated.constBuild10});
    constSeq3 = termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{generated.constCall5, generated.constLChoice10});
    constSDef6 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const148, generated.constCons13, generated.constSeq3});
    constCons57 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef6, (IStrategoList)generated.constCons56);
    const155 = termFactory.makeString("Parenthetical");
    constOp21 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const155, generated.constCons53});
    constNoAnnoList26 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp21});
    constMatch2 = termFactory.makeAppl(Main._consMatch_1, new IStrategoTerm[]{generated.constNoAnnoList26});
    constLChoice11 = termFactory.makeAppl(Main._consLChoice_2, new IStrategoTerm[]{generated.constCallNoArgs0, generated.constMatch2});
    constSeq4 = termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{generated.constLChoice11, generated.constCall2});
    constSDef7 = termFactory.makeAppl(Main._consSDef_3, new IStrategoTerm[]{generated.const153, generated.constCons13, generated.constSeq4});
    constCons58 = (IStrategoTerm)termFactory.makeListCons(generated.constSDef7, (IStrategoList)generated.constCons57);
    constStrategies0 = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{generated.constCons58});
    constCons59 = (IStrategoTerm)termFactory.makeListCons(generated.constStrategies0, (IStrategoList)generated.constNil3);
    const156 = termFactory.makeString("Unknown");
    constSortNoArgs0 = termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{generated.const156});
    constConstType0 = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{generated.constSortNoArgs0});
    constCons60 = (IStrategoTerm)termFactory.makeListCons(generated.constConstType0, (IStrategoList)generated.constNil3);
    constFunType0 = termFactory.makeAppl(Main._consFunType_2, new IStrategoTerm[]{generated.constCons60, generated.constConstType0});
    constOpDecl0 = termFactory.makeAppl(Main._consOpDecl_2, new IStrategoTerm[]{generated.const155, generated.constFunType0});
    constCons61 = (IStrategoTerm)termFactory.makeListCons(generated.constOpDecl0, (IStrategoList)generated.constNil3);
    constConstructors0 = termFactory.makeAppl(Main._consConstructors_1, new IStrategoTerm[]{generated.constCons61});
    constCons62 = (IStrategoTerm)termFactory.makeListCons(generated.constConstructors0, (IStrategoList)generated.constNil3);
    constSignature0 = termFactory.makeAppl(Main._consSignature_1, new IStrategoTerm[]{generated.constCons62});
    constCons63 = (IStrategoTerm)termFactory.makeListCons(generated.constSignature0, (IStrategoList)generated.constCons59);
    const157 = termFactory.makeString("libstratego-gpp");
    constImport0 = termFactory.makeAppl(Main._consImport_1, new IStrategoTerm[]{generated.const157});
    constCons64 = (IStrategoTerm)termFactory.makeListCons(generated.constImport0, (IStrategoList)generated.constNil3);
    const158 = termFactory.makeString("libstratego-lib");
    constImport1 = termFactory.makeAppl(Main._consImport_1, new IStrategoTerm[]{generated.const158});
    constCons65 = (IStrategoTerm)termFactory.makeListCons(generated.constImport1, (IStrategoList)generated.constCons64);
    constImports0 = termFactory.makeAppl(Main._consImports_1, new IStrategoTerm[]{generated.constCons65});
    constCons66 = (IStrategoTerm)termFactory.makeListCons(generated.constImports0, (IStrategoList)generated.constCons63);
    const159 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'templatelang-sort-to-strategy'");
    const160 = termFactory.makeString("\n");
    const161 = termFactory.makeString("\n            ");
    const162 = termFactory.makeString("prettyprint-");
    const163 = termFactory.makeString("is-string");
    constSVar8 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const163});
    constCallNoArgs2 = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{generated.constSVar8});
    constRootApp5 = termFactory.makeAppl(Main._consRootApp_1, new IStrategoTerm[]{generated.constCallNoArgs2});
    constCons67 = (IStrategoTerm)termFactory.makeListCons(generated.constRootApp5, (IStrategoList)generated.constNil3);
    constOp22 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const131, generated.constCons67});
    constNoAnnoList27 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp22});
    constCons68 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList27, (IStrategoList)generated.constNil3);
    constList4 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constCons68});
    constNoAnnoList28 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList4});
    constBuild11 = termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{generated.constNoAnnoList28});
    constLayout0 = termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{generated.const121});
    const164 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'template-to-prettyprint-strategy'");
    const165 = termFactory.makeString("generate BOX-based pretty printer from");
    const166 = termFactory.makeInt(0);
    const167 = termFactory.makeString("a");
    constVar3 = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{generated.const167});
    const168 = termFactory.makeString("Failed to pretty-print template");
    const169 = termFactory.makeString("Failed to rename template elements");
    const170 = termFactory.makeInt(97);
    const171 = termFactory.makeString("Failed to rename template element");
    constSVar9 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const139});
    constStr1 = termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{generated.const121});
    constNoAnnoList29 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constStr1});
    constCons69 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList29, (IStrategoList)generated.constNil3);
    constOp23 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const131, generated.constCons69});
    constNoAnnoList30 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp23});
    constCons70 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList30, (IStrategoList)generated.constNil3);
    constList5 = termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{generated.constCons70});
    constNoAnnoList31 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constList5});
    constCons71 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList31, (IStrategoList)generated.constNil3);
    constCons72 = (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList0, (IStrategoList)generated.constCons71);
    constOp24 = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const138, generated.constCons72});
    constNoAnnoList32 = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{generated.constOp24});
    const172 = termFactory.makeString("Failed to determine placeholder type");
    const173 = termFactory.makeString("Failed to determine placeholder type (option)");
    constSVar10 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const150});
    const174 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'ppl'");
    const175 = termFactory.makeString("\n   ");
    const176 = termFactory.makeString("-list");
    constCons73 = (IStrategoTerm)termFactory.makeListCons(generated.const176, (IStrategoList)generated.constNil3);
    const177 = termFactory.makeString("pp-");
    const178 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'ppx'");
    constSVar11 = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{generated.const145});
    const179 = termFactory.makeString("Failed to convert list placeholder");
    const180 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'vbox-type'");
    const181 = termFactory.makeString("\n       ");
    const182 = termFactory.makeString("pp-one-");
    const183 = termFactory.makeString("Failed to determine placeholder box type (V or Z)");
    const184 = termFactory.makeString("Failed to generate signature from production :: templatelang-production-to-signature (1)");
    const185 = termFactory.makeString("Failed to generate signature from production :: templatelang-production-to-signature (2)");
    const186 = termFactory.makeString("generate signature from");
    const187 = termFactory.makeString("Option");
    const188 = termFactory.makeString("List");
    constKeywordFollowRestriction0 = termFactory.makeAppl(Main._consKeywordFollowRestriction_0, NO_TERMS);
    const189 = termFactory.makeString("Failed: ");
    const190 = termFactory.makeString("Failed to convert TemplateSection to SDF");
    constno_attrs0 = termFactory.makeAppl(Main._consno_attrs_0, NO_TERMS);
    const191 = termFactory.makeString("generate SDF (no attrs) from");
    const192 = termFactory.makeString("generate SDF from");
    constNewlines0 = termFactory.makeAppl(Main._consNewlines_0, NO_TERMS);
    const193 = termFactory.makeString("\"\\n\"");
    const194 = termFactory.makeInt(1);
    constlit0 = termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{generated.const193});
    constString0 = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{generated.const160});
    constCons74 = (IStrategoTerm)termFactory.makeListCons(generated.constString0, (IStrategoList)generated.constNil3);
    const195 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'sort-to-contentcomplete'");
    const196 = termFactory.makeString("\"");
    constCons75 = (IStrategoTerm)termFactory.makeListCons(generated.const196, (IStrategoList)generated.constNil3);
    const197 = termFactory.makeString("\"COMPLETION-");
    const198 = termFactory.makeString("CONTENTCOMPLETE");
    constsort0 = termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{generated.const198});
    constCons76 = (IStrategoTerm)termFactory.makeListCons(generated.constsort0, (IStrategoList)generated.constNil3);
    const199 = termFactory.makeString("cons");
    constunquoted0 = termFactory.makeAppl(Main._consunquoted_1, new IStrategoTerm[]{generated.const199});
    constTokenize0 = termFactory.makeAppl(Main._consTokenize_0, NO_TERMS);
    constBlank0 = termFactory.makeAppl(Main._consBlank_0, NO_TERMS);
    constCons77 = (IStrategoTerm)termFactory.makeListCons(generated.constBlank0, (IStrategoList)generated.constNil3);
    const200 = termFactory.makeString("generate completion templates from");
    const201 = termFactory.makeString("\\n");
    const202 = termFactory.makeString(" ");
    const203 = termFactory.makeString("\\t");
    const204 = termFactory.makeInt(32);
    constCursor0 = termFactory.makeAppl(Main._consCursor_0, NO_TERMS);
    constCons78 = (IStrategoTerm)termFactory.makeListCons(generated.constCursor0, (IStrategoList)generated.constNil3);
    const205 = termFactory.makeString("  ");
    const206 = termFactory.makeString("	");
    const207 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'template-element-to-esv'");
    const208 = termFactory.makeString("\n ");
    const209 = termFactory.makeString(":");
    constCons79 = (IStrategoTerm)termFactory.makeListCons(generated.const209, (IStrategoList)generated.constNil3);
    const210 = termFactory.makeString("<");
    const211 = termFactory.makeString("<:");
    constLayout1 = termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{generated.const202});
    const212 = termFactory.makeString("Warning: Could not generate template from production: ");
    constNone0 = termFactory.makeAppl(Main._consNone_0, NO_TERMS);
    constOption0 = termFactory.makeAppl(Main._consOption_0, NO_TERMS);
    constStar0 = termFactory.makeAppl(Main._consStar_0, NO_TERMS);
    constPlus0 = termFactory.makeAppl(Main._consPlus_0, NO_TERMS);
    const213 = termFactory.makeString("Warning: Could not generate template element from symbol: ");
    const214 = termFactory.makeInt(-100);
    const215 = termFactory.makeInt(50);
    const216 = termFactory.makeInt(-50);
    const217 = termFactory.makeString("Expanded");
    const218 = termFactory.makeString("-531873");
    constTemplateBySort0 = termFactory.makeAppl(Main._consTemplateBySort_0, NO_TERMS);
    const219 = termFactory.makeString("Warning: Attempt to desugar already desugared template production!");
    const220 = termFactory.makeInt(92);
    const221 = termFactory.makeInt(34);
    const222 = termFactory.makeInt(39);
    const223 = termFactory.makeInt(9);
    const224 = termFactory.makeInt(13);
    const225 = termFactory.makeInt(10);
    const226 = termFactory.makeInt(60);
    const227 = termFactory.makeInt(62);
    const228 = termFactory.makeInt(91);
    const229 = termFactory.makeInt(93);
    const230 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'templatelang-not-desugared'");
    const231 = termFactory.makeString("\n                  ");
    const232 = termFactory.makeString(" sugared template production!");
    constCons80 = (IStrategoTerm)termFactory.makeListCons(generated.const232, (IStrategoList)generated.constNil3);
    const233 = termFactory.makeString("Error: Attempt to ");
    const234 = termFactory.makeString("fetch sort from");
    constTemplateBySortCons0 = termFactory.makeAppl(Main._consTemplateBySortCons_0, NO_TERMS);
    const235 = termFactory.makeString("analyze");
    constTemplateOption0 = termFactory.makeAppl(Main._consTemplateOption_0, NO_TERMS);
    const236 = termFactory.makeString("Failed to get template option");
    const237 = termFactory.makeString("TemplateLangCachedOption");
    const238 = termFactory.makeString("-431918");
    const239 = termFactory.makeString("Failed to index template option");
    const240 = termFactory.makeTuple(generated.constNewlines0, generated.constTemplateOption0);
    const241 = termFactory.makeTuple(generated.constNewlines0, generated.constNone0);
    const242 = termFactory.makeTuple(generated.constKeywordFollowRestriction0, generated.constNone0);
    const243 = termFactory.makeInt(41);
    constCons81 = (IStrategoTerm)termFactory.makeListCons(generated.const243, (IStrategoList)generated.constNil3);
    const244 = termFactory.makeInt(40);
    constCons82 = (IStrategoTerm)termFactory.makeListCons(generated.const244, (IStrategoList)generated.constCons81);
    const245 = termFactory.makeTuple(generated.constTokenize0, generated.constCons82);
    constattrs0 = termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{generated.constNil3});
    const246 = termFactory.makeInt(80);
    constEditorServiceprettyPpAf = new ImportTerm(termFactory, generated.class, "/org/strategoxt/imp/editors/template/generated/", "EditorService-pretty.pp.af");
    const247 = termFactory.makeString("DescriptorPPTable");
    constDR_DUMMY0 = termFactory.makeAppl(Main._consDR_DUMMY_0, NO_TERMS);
    constCons83 = (IStrategoTerm)termFactory.makeListCons(generated.constDR_DUMMY0, (IStrategoList)generated.constNil3);
    const248 = termFactory.makeString("-56401");
    const249 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'pp-fix-string-quotes'");
    const250 = termFactory.makeString(">");
    const251 = termFactory.makeString("Stratego");
    const252 = termFactory.makeString("\\");
    const253 = termFactory.makeString("\\\\");
    const254 = termFactory.makeString("\r");
    const255 = termFactory.makeString("\\r");
    const256 = termFactory.makeString("'");
    const257 = termFactory.makeString("\\'");
    const258 = termFactory.makeString("\\\"");
    const259 = termFactory.makeString("with-spxverify (no message)");
    const260 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'with-verify'");
    const261 = termFactory.makeString("\n                                                         ");
    const262 = termFactory.makeString("\"Internal error: with clause failed unexpectedly. More : ");
    const263 = termFactory.makeString("Internal error: with clause failed unexpectedly");
    constCritical0 = termFactory.makeAppl(Main._consCritical_0, NO_TERMS);
    const264 = termFactory.makeString("<?>");
    const265 = termFactory.makeString("Warning - Contract: Requires Failed. Reason :");
    const266 = termFactory.makeString("  actual   : ");
    const267 = termFactory.makeString("  expected : ");
    const268 = termFactory.makeString("  input : ");
  }

  public static void registerInterop(org.spoofax.interpreter.core.IContext context, Context compiledContext)
  { 
    new InteropRegisterer().registerLazy(context, compiledContext, InteropRegisterer.class.getClassLoader());
  }
}