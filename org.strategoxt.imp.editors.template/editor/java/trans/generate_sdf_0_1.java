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

@SuppressWarnings("all") public class generate_sdf_0_1 extends Strategy 
{ 
  public static generate_sdf_0_1 instance = new generate_sdf_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm c_33005)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_sdf_0_1");
    Fail1937:
    { 
      IStrategoTerm l_33005 = null;
      IStrategoTerm n_33005 = null;
      IStrategoTerm h_33005 = null;
      IStrategoTerm j_33005 = null;
      IStrategoTerm k_33005 = null;
      IStrategoTerm term717 = term;
      Success701:
      { 
        Fail1938:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1938;
          if(true)
            break Success701;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term717);
        if(term == null)
          break Fail1937;
      }
      term = template_sections_to_sdf_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1937;
      n_33005 = term;
      term = base_filename_0_0.instance.invoke(context, c_33005);
      if(term == null)
        break Fail1937;
      term = remove_extension_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1937;
      IStrategoTerm term718 = term;
      Success702:
      { 
        Fail1939:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1939;
          if(true)
            break Success702;
        }
        term = term718;
        IStrategoTerm term719 = term;
        Success703:
        { 
          Fail1940:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1940;
            if(true)
              break Success703;
          }
          term = term719;
          IStrategoTerm term720 = term;
          Success704:
          { 
            Fail1941:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1941;
              if(true)
                break Success704;
            }
            term = term720;
            IStrategoTerm term721 = term;
            Success705:
            { 
              Fail1942:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1942;
                if(true)
                  break Success705;
              }
              term = term721;
              IStrategoTerm d_33005 = null;
              IStrategoTerm e_33005 = null;
              IStrategoTerm g_33005 = null;
              d_33005 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1937;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1937;
              e_33005 = ((IStrategoList)term).tail();
              g_33005 = e_33005;
              term = report_failure_0_2.instance.invoke(context, g_33005, trans.const299, d_33005);
              if(term == null)
                break Fail1937;
            }
          }
        }
      }
      j_33005 = term;
      h_33005 = trans.const278;
      k_33005 = j_33005;
      term = string_replace_0_2.instance.invoke(context, k_33005, h_33005, trans.const278);
      if(term == null)
        break Fail1937;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)trans.constCons88);
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1937;
      l_33005 = term;
      term = n_33005;
      term = list_to_conc_grammars_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1937;
      term = termFactory.makeAppl(Main._consmodule_3, new IStrategoTerm[]{termFactory.makeAppl(Main._consunparameterized_1, new IStrategoTerm[]{termFactory.annotateTerm(l_33005, checkListAnnos(termFactory, trans.constNil4))}), trans.constNil4, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consexports_1, new IStrategoTerm[]{term}), (IStrategoList)trans.constNil4)});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}