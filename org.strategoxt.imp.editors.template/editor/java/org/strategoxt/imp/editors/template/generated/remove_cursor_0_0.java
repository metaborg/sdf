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

@SuppressWarnings("all") public class remove_cursor_0_0 extends Strategy 
{ 
  public static remove_cursor_0_0 instance = new remove_cursor_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("remove_cursor_0_0");
    Fail998:
    { 
      IStrategoTerm term437 = term;
      Success385:
      { 
        Fail999:
        { 
          IStrategoTerm n_32765 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail999;
          IStrategoTerm arg382 = ((IStrategoList)term).head();
          if(arg382.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg382).isEmpty())
            break Fail999;
          IStrategoTerm arg384 = ((IStrategoList)arg382).tail();
          if(arg384.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg384).isEmpty())
            break Fail999;
          IStrategoTerm arg385 = ((IStrategoList)arg384).head();
          if(arg385.getTermType() != IStrategoTerm.APPL || Main._consCursor_0 != ((IStrategoAppl)arg385).getConstructor())
            break Fail999;
          IStrategoTerm arg386 = ((IStrategoList)arg384).tail();
          if(arg386.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg386).isEmpty())
            break Fail999;
          n_32765 = ((IStrategoList)term).tail();
          term = this.invoke(context, n_32765);
          if(term == null)
            break Fail999;
          if(true)
            break Success385;
        }
        term = term437;
        IStrategoTerm term438 = term;
        Success386:
        { 
          Fail1000:
          { 
            IStrategoTerm i_32765 = null;
            IStrategoTerm j_32765 = null;
            IStrategoTerm k_32765 = null;
            IStrategoTerm l_32765 = null;
            IStrategoTerm m_32765 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1000;
            i_32765 = ((IStrategoList)term).head();
            j_32765 = ((IStrategoList)term).tail();
            IStrategoList annos27 = term.getAnnotations();
            m_32765 = annos27;
            k_32765 = i_32765;
            term = this.invoke(context, j_32765);
            if(term == null)
              break Fail1000;
            l_32765 = term;
            IStrategoList list14;
            list14 = checkListTail(l_32765);
            if(list14 == null)
              break Fail1000;
            term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(k_32765, list14), checkListAnnos(termFactory, m_32765));
            if(true)
              break Success386;
          }
          term = term438;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail998;
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