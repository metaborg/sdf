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

@SuppressWarnings("all") final class e_9747 extends Strategy 
{ 
  public static final e_9747 instance = new e_9747();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail726:
    { 
      IStrategoTerm term366 = term;
      Success301:
      { 
        Fail727:
        { 
          IStrategoTerm f_9747 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail727;
          IStrategoTerm arg560 = ((IStrategoList)term).head();
          if(arg560.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg560).getConstructor())
            break Fail727;
          IStrategoTerm arg561 = arg560.getSubterm(0);
          if(arg561.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)arg561).stringValue()))
            break Fail727;
          f_9747 = ((IStrategoList)term).tail();
          term = this.invoke(context, f_9747);
          if(term == null)
            break Fail727;
          if(true)
            break Success301;
        }
        term = term366;
        IStrategoTerm term367 = term;
        Success302:
        { 
          Fail728:
          { 
            IStrategoTerm w_9746 = null;
            IStrategoTerm x_9746 = null;
            IStrategoTerm y_9746 = null;
            IStrategoTerm g_9747 = null;
            IStrategoTerm h_9747 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail728;
            IStrategoTerm arg562 = ((IStrategoList)term).head();
            if(arg562.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg562).getConstructor())
              break Fail728;
            w_9746 = arg562.getSubterm(0);
            IStrategoTerm arg563 = ((IStrategoList)term).tail();
            if(arg563.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg563).isEmpty())
              break Fail728;
            IStrategoTerm arg564 = ((IStrategoList)arg563).head();
            if(arg564.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg564).getConstructor())
              break Fail728;
            x_9746 = arg564.getSubterm(0);
            y_9746 = ((IStrategoList)arg563).tail();
            h_9747 = term;
            term = termFactory.makeTuple(w_9746, x_9746);
            term = conc_strings_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail728;
            g_9747 = term;
            term = h_9747;
            IStrategoList list43;
            list43 = checkListTail(y_9746);
            if(list43 == null)
              break Fail728;
            term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{g_9747}), list43);
            term = this.invoke(context, term);
            if(term == null)
              break Fail728;
            if(true)
              break Success302;
          }
          term = term367;
          IStrategoTerm term368 = term;
          Success303:
          { 
            Fail729:
            { 
              IStrategoTerm z_9746 = null;
              IStrategoTerm a_9747 = null;
              IStrategoTerm b_9747 = null;
              IStrategoTerm c_9747 = null;
              IStrategoTerm d_9747 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail729;
              z_9746 = ((IStrategoList)term).head();
              a_9747 = ((IStrategoList)term).tail();
              IStrategoList annos14 = term.getAnnotations();
              d_9747 = annos14;
              b_9747 = z_9746;
              term = this.invoke(context, a_9747);
              if(term == null)
                break Fail729;
              c_9747 = term;
              IStrategoList list44;
              list44 = checkListTail(c_9747);
              if(list44 == null)
                break Fail729;
              term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(b_9747, list44), checkListAnnos(termFactory, d_9747));
              if(true)
                break Success303;
            }
            term = term368;
            if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
              break Fail726;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}