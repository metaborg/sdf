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
    Fail178:
    { 
      IStrategoTerm term181 = term;
      Success129:
      { 
        Fail179:
        { 
          IStrategoTerm e_9727 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail179;
          IStrategoTerm arg229 = ((IStrategoList)term).head();
          if(arg229.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg229).isEmpty())
            break Fail179;
          IStrategoTerm arg231 = ((IStrategoList)arg229).tail();
          if(arg231.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg231).isEmpty())
            break Fail179;
          IStrategoTerm arg232 = ((IStrategoList)arg231).head();
          if(arg232.getTermType() != IStrategoTerm.APPL || Main._consCursor_0 != ((IStrategoAppl)arg232).getConstructor())
            break Fail179;
          IStrategoTerm arg233 = ((IStrategoList)arg231).tail();
          if(arg233.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg233).isEmpty())
            break Fail179;
          e_9727 = ((IStrategoList)term).tail();
          term = this.invoke(context, e_9727);
          if(term == null)
            break Fail179;
          if(true)
            break Success129;
        }
        term = term181;
        IStrategoTerm term182 = term;
        Success130:
        { 
          Fail180:
          { 
            IStrategoTerm z_9726 = null;
            IStrategoTerm a_9727 = null;
            IStrategoTerm b_9727 = null;
            IStrategoTerm c_9727 = null;
            IStrategoTerm d_9727 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail180;
            z_9726 = ((IStrategoList)term).head();
            a_9727 = ((IStrategoList)term).tail();
            IStrategoList annos9 = term.getAnnotations();
            d_9727 = annos9;
            b_9727 = z_9726;
            term = this.invoke(context, a_9727);
            if(term == null)
              break Fail180;
            c_9727 = term;
            IStrategoList list11;
            list11 = checkListTail(c_9727);
            if(list11 == null)
              break Fail180;
            term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(b_9727, list11), checkListAnnos(termFactory, d_9727));
            if(true)
              break Success130;
          }
          term = term182;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail178;
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