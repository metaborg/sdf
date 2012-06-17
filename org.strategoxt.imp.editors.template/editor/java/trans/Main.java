package trans;

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

  protected static IStrategoTerm const310;

  protected static IStrategoTerm const309;

  protected static IStrategoTerm constCritical1;

  protected static IStrategoTerm const308;

  protected static IStrategoTerm constNone1;

  protected static IStrategoTerm const307;

  protected static IStrategoTerm const306;

  protected static IStrategoTerm const305;

  protected static IStrategoTerm const304;

  protected static IStrategoTerm const303;

  protected static IStrategoTerm const302;

  protected static IStrategoTerm const301;

  protected static IStrategoTerm constCons88;

  protected static IStrategoTerm const300;

  protected static IStrategoTerm const299;

  protected static IStrategoTerm const298;

  protected static IStrategoTerm const297;

  protected static IStrategoTerm constNoImports0;

  protected static IStrategoTerm const296;

  protected static IStrategoTerm const295;

  protected static IStrategoTerm const294;

  protected static IStrategoTerm const293;

  protected static IStrategoTerm const292;

  protected static IStrategoTerm const291;

  protected static IStrategoTerm const290;

  protected static IStrategoTerm const289;

  protected static IStrategoTerm constCons87;

  protected static IStrategoTerm constMARKER0;

  protected static IStrategoTerm const288;

  protected static IStrategoTerm constCons86;

  protected static IStrategoTerm const287;

  protected static IStrategoTerm const286;

  protected static IStrategoTerm const285;

  protected static IStrategoTerm const284;

  protected static IStrategoTerm const283;

  protected static IStrategoTerm constCons85;

  protected static IStrategoTerm const282;

  protected static IStrategoTerm const281;

  protected static IStrategoTerm const280;

  protected static IStrategoTerm const279;

  protected static IStrategoTerm const278;

  protected static IStrategoTerm const277;

  protected static IStrategoTerm const276;

  protected static IStrategoTerm const275;

  protected static IStrategoTerm const274;

  protected static IStrategoTerm const273;

  protected static IStrategoTerm const272;

  protected static IStrategoTerm const271;

  public static IStrategoTerm getTemplateLangPpAf()
  { 
    return constTemplateLangPpAf;
  }

  protected static ImportTerm constTemplateLangPpAf;

  public static IStrategoTerm getTemplateLangGeneratedPpAf()
  { 
    return constTemplateLangGeneratedPpAf;
  }

  protected static ImportTerm constTemplateLangGeneratedPpAf;

  public static IStrategoTerm getTemplateLangTbl1()
  { 
    return constTemplateLangTbl1;
  }

  protected static ImportTerm constTemplateLangTbl1;

  public static IStrategoTerm getTemplateLangTbl0()
  { 
    return constTemplateLangTbl0;
  }

  protected static ImportTerm constTemplateLangTbl0;

  public static IStrategoTerm getTemplateLangTbl()
  { 
    return constTemplateLangTbl;
  }

  protected static ImportTerm constTemplateLangTbl;

  protected static IStrategoTerm const270;

  protected static IStrategoTerm constCons84;

  protected static IStrategoTerm constDR_DUMMY1;

  protected static IStrategoTerm constNil4;

  protected static IStrategoTerm const269;

  public static IStrategoConstructor _consConc_2;

  public static IStrategoConstructor _consSome_1;

  protected static IStrategoConstructor _consCritical_0;

  protected static IStrategoConstructor _consNone_0;

  protected static IStrategoConstructor _consConstructors_1;

  protected static IStrategoConstructor _consSignature_1;

  protected static IStrategoConstructor _consSpecification_1;

  protected static IStrategoConstructor _consexports_1;

  protected static IStrategoConstructor _consunparameterized_1;

  protected static IStrategoConstructor _consmodule_3;

  protected static IStrategoConstructor _consNoImports_0;

  protected static IStrategoConstructor _consModule_3;

  protected static IStrategoConstructor _conscontext_free_syntax_1;

  protected static IStrategoConstructor _conslexical_syntax_1;

  protected static IStrategoConstructor _consprod_3;

  protected static IStrategoConstructor _consDesugared_1;

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

  public static IStrategoConstructor _consDR_DUMMY_0;

  public static IStrategoConstructor _consDR_UNDEFINE_1;

  public static IStrategoConstructor _consString_1;

  public static IStrategoConstructor _consConstructor_1;

  public static IStrategoConstructor _consProperty_0;

  public static IStrategoConstructor _consType_0;

  public static IStrategoConstructor _consType_1;

  public static IStrategoConstructor _consProperty_2;

  public static IStrategoConstructor _consEntity_2;

  public static IStrategoConstructor _consTrue_0;

  public static IStrategoConstructor _consMARKER_0;

  public static IStrategoConstructor _consNOCONTEXT_1;

  public static IStrategoConstructor _consCOMPLETION_1;

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
          resolve_all_symbol_definitions_0_0.instance = new resolve_all_symbol_definitions_0_0_override();
          resolve_symbol_definition_0_0.instance = new resolve_symbol_definition_0_0_override();
          index_symbol_definition_0_0.instance = new index_symbol_definition_0_0_override();
          context.registerComponent("trans");
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
    _consCritical_0 = termFactory.makeConstructor("Critical", 0);
    _consNone_0 = termFactory.makeConstructor("None", 0);
    _consConstructors_1 = termFactory.makeConstructor("Constructors", 1);
    _consSignature_1 = termFactory.makeConstructor("Signature", 1);
    _consSpecification_1 = termFactory.makeConstructor("Specification", 1);
    _consexports_1 = termFactory.makeConstructor("exports", 1);
    _consunparameterized_1 = termFactory.makeConstructor("unparameterized", 1);
    _consmodule_3 = termFactory.makeConstructor("module", 3);
    _consNoImports_0 = termFactory.makeConstructor("NoImports", 0);
    _consModule_3 = termFactory.makeConstructor("Module", 3);
    _conscontext_free_syntax_1 = termFactory.makeConstructor("context-free-syntax", 1);
    _conslexical_syntax_1 = termFactory.makeConstructor("lexical-syntax", 1);
    _consprod_3 = termFactory.makeConstructor("prod", 3);
    _consDesugared_1 = termFactory.makeConstructor("Desugared", 1);
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
    _consDR_DUMMY_0 = termFactory.makeConstructor("DR_DUMMY", 0);
    _consDR_UNDEFINE_1 = termFactory.makeConstructor("DR_UNDEFINE", 1);
    _consString_1 = termFactory.makeConstructor("String", 1);
    _consConstructor_1 = termFactory.makeConstructor("Constructor", 1);
    _consProperty_0 = termFactory.makeConstructor("Property", 0);
    _consType_0 = termFactory.makeConstructor("Type", 0);
    _consType_1 = termFactory.makeConstructor("Type", 1);
    _consProperty_2 = termFactory.makeConstructor("Property", 2);
    _consEntity_2 = termFactory.makeConstructor("Entity", 2);
    _consTrue_0 = termFactory.makeConstructor("True", 0);
    _consMARKER_0 = termFactory.makeConstructor("MARKER", 0);
    _consNOCONTEXT_1 = termFactory.makeConstructor("NOCONTEXT", 1);
    _consCOMPLETION_1 = termFactory.makeConstructor("COMPLETION", 1);
  }

  public static void initConstants(ITermFactory termFactory)
  { 
    const269 = termFactory.makeString("Declaration");
    constNil4 = (IStrategoTerm)termFactory.makeList(Term.NO_TERMS);
    constDR_DUMMY1 = termFactory.makeAppl(Main._consDR_DUMMY_0, NO_TERMS);
    constCons84 = (IStrategoTerm)termFactory.makeListCons(trans.constDR_DUMMY1, (IStrategoList)trans.constNil4);
    const270 = termFactory.makeString("-220620");
    constTemplateLangTbl = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangTbl0 = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangTbl1 = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangGeneratedPpAf = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.generated.pp.af");
    constTemplateLangPpAf = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.pp.af");
    const271 = termFactory.makeInt(100);
    const272 = termFactory.makeString("TemplateLang");
    const273 = termFactory.makeString("CurrentFile");
    const274 = termFactory.makeString("99705");
    const275 = termFactory.makeString("IsImported");
    const276 = termFactory.makeString("-597601");
    const277 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'open-wildcard-import'");
    const278 = termFactory.makeString("\n");
    const279 = termFactory.makeString("\n       ");
    const280 = termFactory.makeString("/");
    const281 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'import-cache-path'");
    const282 = termFactory.makeString("/.cache");
    constCons85 = (IStrategoTerm)termFactory.makeListCons(trans.const282, (IStrategoList)trans.constNil4);
    const283 = termFactory.makeString("+");
    const284 = termFactory.makeString("\\");
    const285 = termFactory.makeString(":");
    const286 = termFactory.makeString("\n            ");
    const287 = termFactory.makeString(".sig");
    constCons86 = (IStrategoTerm)termFactory.makeListCons(trans.const287, (IStrategoList)trans.constNil4);
    const288 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'import-cache-path'");
    constMARKER0 = termFactory.makeAppl(Main._consMARKER_0, NO_TERMS);
    constCons87 = (IStrategoTerm)termFactory.makeListCons(trans.constMARKER0, (IStrategoList)trans.constNil4);
    const289 = termFactory.makeInt(0);
    const290 = termFactory.makeString("BACKGROUNDED");
    const291 = termFactory.makeString("-source.spt");
    const292 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'editor-analyze'");
    const293 = termFactory.makeString("aterm");
    const294 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-aterm'");
    const295 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'collect-sections-2'");
    const296 = termFactory.makeString("example");
    constNoImports0 = termFactory.makeAppl(Main._consNoImports_0, NO_TERMS);
    const297 = termFactory.makeString("generated.esv");
    const298 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-esv-concrete'");
    const299 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in strategy 'generate-sdf'");
    const300 = termFactory.makeString("generated");
    constCons88 = (IStrategoTerm)termFactory.makeListCons(trans.const300, (IStrategoList)trans.constNil4);
    const301 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-sdf-abstract'");
    const302 = termFactory.makeString("generated.sdf");
    const303 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-sdf-concrete'");
    const304 = termFactory.makeString("generated.str");
    const305 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-box-pp-concrete'");
    const306 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-signature-concrete'");
    const307 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-all'");
    constNone1 = termFactory.makeAppl(Main._consNone_0, NO_TERMS);
    const308 = termFactory.makeString("w");
    constCritical1 = termFactory.makeAppl(Main._consCritical_0, NO_TERMS);
    const309 = termFactory.makeString("Internal error: with clause failed unexpectedly in strategy 'write-string-to-file'");
    const310 = termFactory.makeString("");
  }

  public static void registerInterop(org.spoofax.interpreter.core.IContext context, Context compiledContext)
  { 
    new InteropRegisterer().registerLazy(context, compiledContext, InteropRegisterer.class.getClassLoader());
  }
}