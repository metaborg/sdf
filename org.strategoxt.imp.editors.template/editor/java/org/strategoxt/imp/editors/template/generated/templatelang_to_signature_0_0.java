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
    Fail73:
    { 
      IStrategoTerm term81 = term;
      Success54:
      { 
        Fail74:
        { 
          IStrategoTerm k_9716 = null;
          IStrategoTerm l_9716 = null;
          IStrategoTerm m_9716 = null;
          IStrategoTerm n_9716 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
            break Fail74;
          k_9716 = term.getSubterm(0);
          IStrategoTerm arg80 = term.getSubterm(1);
          n_9716 = arg80;
          if(arg80.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg80).isEmpty())
            break Fail74;
          l_9716 = term.getSubterm(2);
          term = fetch_cons_name_0_0.instance.invoke(context, l_9716);
          if(term == null)
            break Fail74;
          m_9716 = term;
          term = map_1_0.instance.invoke(context, n_9716, templatelang_placeholder_to_signature_arg_0_0.instance);
          if(term == null)
            break Fail74;
          term = termFactory.makeAppl(Main._consOpDecl_2, new IStrategoTerm[]{m_9716, termFactory.makeAppl(Main._consFunType_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{k_9716})})})});
          if(true)
            break Success54;
        }
        term = term81;
        IStrategoTerm term82 = term;
        Success55:
        { 
          Fail75:
          { 
            IStrategoTerm f_9716 = null;
            IStrategoTerm g_9716 = null;
            IStrategoTerm h_9716 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
              break Fail75;
            f_9716 = term.getSubterm(0);
            IStrategoTerm arg83 = term.getSubterm(1);
            h_9716 = arg83;
            if(arg83.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg83).isEmpty())
              break Fail75;
            g_9716 = term.getSubterm(2);
            IStrategoTerm term83 = term;
            Success56:
            { 
              Fail76:
              { 
                term = fetch_cons_name_0_0.instance.invoke(context, g_9716);
                if(term == null)
                  break Fail76;
                { 
                  if(true)
                    break Fail75;
                  if(true)
                    break Success56;
                }
              }
              term = term83;
            }
            term = map_1_0.instance.invoke(context, h_9716, templatelang_placeholder_to_signature_arg_0_0.instance);
            if(term == null)
              break Fail75;
            term = termFactory.makeAppl(Main._consOpDeclInj_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consFunType_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{f_9716})})})});
            if(true)
              break Success55;
          }
          term = term82;
          IStrategoTerm term84 = term;
          Success57:
          { 
            Fail77:
            { 
              IStrategoTerm b_9716 = null;
              IStrategoTerm c_9716 = null;
              if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
                break Fail77;
              b_9716 = term.getSubterm(0);
              IStrategoTerm arg86 = term.getSubterm(1);
              if(arg86.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg86).isEmpty())
                break Fail77;
              c_9716 = term.getSubterm(2);
              term = fetch_cons_name_0_0.instance.invoke(context, c_9716);
              if(term == null)
                break Fail77;
              term = termFactory.makeAppl(Main._consOpDecl_2, new IStrategoTerm[]{term, termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{b_9716})})});
              if(true)
                break Success57;
            }
            term = term84;
            IStrategoTerm y_9715 = null;
            IStrategoTerm z_9715 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
              break Fail73;
            y_9715 = term.getSubterm(0);
            IStrategoTerm arg87 = term.getSubterm(1);
            if(arg87.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg87).isEmpty())
              break Fail73;
            z_9715 = term.getSubterm(2);
            IStrategoTerm term85 = term;
            Success58:
            { 
              Fail78:
              { 
                term = fetch_cons_name_0_0.instance.invoke(context, z_9715);
                if(term == null)
                  break Fail78;
                { 
                  if(true)
                    break Fail73;
                  if(true)
                    break Success58;
                }
              }
              term = term85;
            }
            term = termFactory.makeAppl(Main._consOpDeclInj_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{y_9715})})});
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