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

@SuppressWarnings("all") public class templatelang_to_signature_0_0 extends Strategy 
{ 
  public static templatelang_to_signature_0_0 instance = new templatelang_to_signature_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_to_signature_0_0");
    Fail892:
    { 
      IStrategoTerm term336 = term;
      Success309:
      { 
        Fail893:
        { 
          IStrategoTerm s_32754 = null;
          IStrategoTerm t_32754 = null;
          IStrategoTerm u_32754 = null;
          IStrategoTerm v_32754 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
            break Fail893;
          s_32754 = term.getSubterm(0);
          IStrategoTerm arg228 = term.getSubterm(1);
          v_32754 = arg228;
          if(arg228.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg228).isEmpty())
            break Fail893;
          t_32754 = term.getSubterm(2);
          term = fetch_cons_name_0_0.instance.invoke(context, t_32754);
          if(term == null)
            break Fail893;
          u_32754 = term;
          term = map_1_0.instance.invoke(context, v_32754, templatelang_placeholder_to_signature_arg_0_0.instance);
          if(term == null)
            break Fail893;
          term = termFactory.makeAppl(Main._consOpDecl_2, new IStrategoTerm[]{u_32754, termFactory.makeAppl(Main._consFunType_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{s_32754})})})});
          if(true)
            break Success309;
        }
        term = term336;
        IStrategoTerm term337 = term;
        Success310:
        { 
          Fail894:
          { 
            IStrategoTerm n_32754 = null;
            IStrategoTerm o_32754 = null;
            IStrategoTerm p_32754 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
              break Fail894;
            n_32754 = term.getSubterm(0);
            IStrategoTerm arg231 = term.getSubterm(1);
            p_32754 = arg231;
            if(arg231.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg231).isEmpty())
              break Fail894;
            o_32754 = term.getSubterm(2);
            IStrategoTerm term338 = term;
            Success311:
            { 
              Fail895:
              { 
                term = fetch_cons_name_0_0.instance.invoke(context, o_32754);
                if(term == null)
                  break Fail895;
                { 
                  if(true)
                    break Fail894;
                  if(true)
                    break Success311;
                }
              }
              term = term338;
            }
            term = map_1_0.instance.invoke(context, p_32754, templatelang_placeholder_to_signature_arg_0_0.instance);
            if(term == null)
              break Fail894;
            term = termFactory.makeAppl(Main._consOpDeclInj_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consFunType_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{n_32754})})})});
            if(true)
              break Success310;
          }
          term = term337;
          IStrategoTerm term339 = term;
          Success312:
          { 
            Fail896:
            { 
              IStrategoTerm j_32754 = null;
              IStrategoTerm k_32754 = null;
              if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
                break Fail896;
              j_32754 = term.getSubterm(0);
              IStrategoTerm arg234 = term.getSubterm(1);
              if(arg234.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg234).isEmpty())
                break Fail896;
              k_32754 = term.getSubterm(2);
              term = fetch_cons_name_0_0.instance.invoke(context, k_32754);
              if(term == null)
                break Fail896;
              term = termFactory.makeAppl(Main._consOpDecl_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{j_32754})})});
              if(true)
                break Success312;
            }
            term = term339;
            IStrategoTerm g_32754 = null;
            IStrategoTerm h_32754 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
              break Fail892;
            g_32754 = term.getSubterm(0);
            IStrategoTerm arg235 = term.getSubterm(1);
            if(arg235.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg235).isEmpty())
              break Fail892;
            h_32754 = term.getSubterm(2);
            IStrategoTerm term340 = term;
            Success313:
            { 
              Fail897:
              { 
                term = fetch_cons_name_0_0.instance.invoke(context, h_32754);
                if(term == null)
                  break Fail897;
                { 
                  if(true)
                    break Fail892;
                  if(true)
                    break Success313;
                }
              }
              term = term340;
            }
            term = termFactory.makeAppl(Main._consOpDeclInj_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{g_32754})})});
          }
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}