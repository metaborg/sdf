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

  protected static IStrategoTerm const38;

  protected static IStrategoTerm const37;

  protected static IStrategoTerm constCritical0;

  protected static IStrategoTerm const36;

  protected static IStrategoTerm constNone0;

  protected static IStrategoTerm const35;

  protected static IStrategoTerm const34;

  protected static IStrategoTerm const33;

  protected static IStrategoTerm const32;

  protected static IStrategoTerm const31;

  protected static IStrategoTerm const30;

  protected static IStrategoTerm constunparameterized0;

  protected static IStrategoTerm const29;

  protected static IStrategoTerm const28;

  protected static IStrategoTerm constNoImports0;

  protected static IStrategoTerm const27;

  protected static IStrategoTerm const26;

  protected static IStrategoTerm const25;

  protected static IStrategoTerm const24;

  protected static IStrategoTerm const23;

  protected static IStrategoTerm const22;

  protected static IStrategoTerm const21;

  protected static IStrategoTerm const20;

  protected static IStrategoTerm constCons3;

  protected static IStrategoTerm constMARKER0;

  protected static IStrategoTerm const19;

  protected static IStrategoTerm const18;

  protected static IStrategoTerm constCons2;

  protected static IStrategoTerm const17;

  protected static IStrategoTerm const16;

  protected static IStrategoTerm const15;

  protected static IStrategoTerm const14;

  protected static IStrategoTerm const13;

  protected static IStrategoTerm constCons1;

  protected static IStrategoTerm const12;

  protected static IStrategoTerm const11;

  protected static IStrategoTerm const10;

  protected static IStrategoTerm const9;

  protected static IStrategoTerm const8;

  protected static IStrategoTerm const7;

  protected static IStrategoTerm const6;

  protected static IStrategoTerm const5;

  protected static IStrategoTerm const4;

  protected static IStrategoTerm const3;

  protected static IStrategoTerm const2;

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

  protected static IStrategoTerm const1;

  protected static IStrategoTerm constCons0;

  protected static IStrategoTerm constDR_DUMMY0;

  protected static IStrategoTerm constNil0;

  protected static IStrategoTerm const0;

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
    const0 = termFactory.makeString("Declaration");
    constNil0 = (IStrategoTerm)termFactory.makeList(Term.NO_TERMS);
    constDR_DUMMY0 = termFactory.makeAppl(Main._consDR_DUMMY_0, NO_TERMS);
    constCons0 = (IStrategoTerm)termFactory.makeListCons(trans.constDR_DUMMY0, (IStrategoList)trans.constNil0);
    const1 = termFactory.makeString("-220620");
    constTemplateLangTbl = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangTbl0 = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangTbl1 = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.tbl");
    constTemplateLangGeneratedPpAf = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.generated.pp.af");
    constTemplateLangPpAf = new ImportTerm(termFactory, trans.class, "/trans/", "TemplateLang.pp.af");
    const2 = termFactory.makeInt(100);
    const3 = termFactory.makeString("CurrentFile");
    const4 = termFactory.makeString("99705");
    const5 = termFactory.makeString("IsImported");
    const6 = termFactory.makeString("-597601");
    const7 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'open-wildcard-import'");
    const8 = termFactory.makeString("\n");
    const9 = termFactory.makeString("\n       ");
    const10 = termFactory.makeString("/");
    const11 = termFactory.makeString("Internal error: escaped term in string quotation is not a string in rule 'import-cache-path'");
    const12 = termFactory.makeString("/.cache");
    constCons1 = (IStrategoTerm)termFactory.makeListCons(trans.const12, (IStrategoList)trans.constNil0);
    const13 = termFactory.makeString("+");
    const14 = termFactory.makeString("\\");
    const15 = termFactory.makeString(":");
    const16 = termFactory.makeString("\n            ");
    const17 = termFactory.makeString(".sig");
    constCons2 = (IStrategoTerm)termFactory.makeListCons(trans.const17, (IStrategoList)trans.constNil0);
    const18 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'import-cache-path'");
    const19 = termFactory.makeString("TemplateLang");
    constMARKER0 = termFactory.makeAppl(Main._consMARKER_0, NO_TERMS);
    constCons3 = (IStrategoTerm)termFactory.makeListCons(trans.constMARKER0, (IStrategoList)trans.constNil0);
    const20 = termFactory.makeInt(0);
    const21 = termFactory.makeString("BACKGROUNDED");
    const22 = termFactory.makeString("-source.spt");
    const23 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'editor-analyze'");
    const24 = termFactory.makeString("aterm");
    const25 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-aterm'");
    const26 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'collect-sections-2'");
    const27 = termFactory.makeString("example");
    constNoImports0 = termFactory.makeAppl(Main._consNoImports_0, NO_TERMS);
    const28 = termFactory.makeString("generated.esv");
    const29 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-esv-concrete'");
    constunparameterized0 = termFactory.makeAppl(Main._consunparameterized_1, new IStrategoTerm[]{trans.const27});
    const30 = termFactory.makeString("generated.sdf");
    const31 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-sdf-concrete'");
    const32 = termFactory.makeString("generated.str");
    const33 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-box-pp-concrete'");
    const34 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-signature-concrete'");
    const35 = termFactory.makeString("Internal error: with clause failed unexpectedly in rule 'generate-all'");
    constNone0 = termFactory.makeAppl(Main._consNone_0, NO_TERMS);
    const36 = termFactory.makeString("w");
    constCritical0 = termFactory.makeAppl(Main._consCritical_0, NO_TERMS);
    const37 = termFactory.makeString("Internal error: with clause failed unexpectedly in strategy 'write-string-to-file'");
    const38 = termFactory.makeString("");
  }

  public static void registerInterop(org.spoofax.interpreter.core.IContext context, Context compiledContext)
  { 
    new InteropRegisterer().registerLazy(context, compiledContext, InteropRegisterer.class.getClassLoader());
  }
}